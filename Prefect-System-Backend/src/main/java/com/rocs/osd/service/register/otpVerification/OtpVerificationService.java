package com.rocs.osd.service.register.otpVerification;

import com.google.common.cache.*;
import com.rocs.osd.domain.otpVerfication.OtpVerification;
import com.rocs.osd.domain.user.User;
import com.rocs.osd.repository.user.UserRepository;
import com.rocs.osd.service.email.EmailService;
import com.rocs.osd.service.login.attempt.LoginAttemptService;
import jakarta.mail.MessagingException;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class OtpVerificationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAttemptService.class);
    private final UserRepository userRepository;
    private final EmailService emailService;

    private final Cache<String, OtpVerification> otpVerificationCache;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public OtpVerificationService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;

        otpVerificationCache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .build();
    }

    public void addUserToOtpCache(OtpVerification otpVerification) throws MessagingException {
        regenerateOtp(otpVerification);
    }

    public OtpVerification getOtpDetails(String otp) {
        return otpVerificationCache.getIfPresent(otp);
    }

    public void evictUserFromLoginAttemptCache(String username) {
        otpVerificationCache.invalidate(username);
    }

    public boolean verifyOtp(String otp, User user) throws MessagingException {
        OtpVerification otpVerification = otpVerificationCache.getIfPresent(otp);
        LOGGER.info("Verifying OTP [{}] for user [{}]", otp, user.getUsername());
        if (otpVerification != null) {
            if (otpVerification.isExpired()) {
                LOGGER.info("OTP [{}] for user [{}] is expired. Regenerating a new one.", otp, user.getUsername());
                regenerateOtp(otpVerification);
                return false;
            }
            user.setLocked(false);
            user.setOtp(null);
            userRepository.save(user);
            otpVerificationCache.invalidate(otp);
            LOGGER.info("OTP verified for user: {}", user.getUsername());
            return true;
        }

        LOGGER.error("OTP [{}] not found for user [{}].", otp, user.getUsername());
        return false;
    }

    private String generateOTP() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    private void regenerateOtp(OtpVerification otpVerification) throws MessagingException {
        String newOtp = generateOTP();
        otpVerification.otp = newOtp;

        emailService.sendNewPasswordEmail(otpVerification.email, newOtp);

        otpVerificationCache.put(newOtp, otpVerification);
        LOGGER.info("New OTP [{}] generated and sent to [{}]. Timer reset to 5 seconds.", newOtp, otpVerification.email);

        scheduleOtpExpiration(otpVerification);
    }

    private void scheduleOtpExpiration(OtpVerification otpVerification) {
        scheduler.schedule(() -> {
            otpVerification.setExpired(true);
            otpVerificationCache.put(otpVerification.otp, otpVerification);
            LOGGER.info("OTP [{}] expired for [{}], but remains in cache.", otpVerification.otp, otpVerification.email);
        }, 1, TimeUnit.MINUTES);
    }
}
