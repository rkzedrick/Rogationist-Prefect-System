package com.rocs.osd.domain.otpVerfication;

public class OtpVerification {
    public String otp;
    public String username;
    public String email;
    private boolean isExpired;

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }
}
