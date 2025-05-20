package com.rocs.osd.service.violation.impl;

import com.rocs.osd.domain.violation.Violation;
import com.rocs.osd.repository.violation.ViolationRepository;
import com.rocs.osd.service.violation.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of Violation interface that interacts with the ViolationRepository
 * to retrieve and manage violation data from the database
 */
@Service
public class ViolationServiceImpl implements ViolationService {
    private ViolationRepository violationRepository;

    /**
     * Constructs an instance of ViolationServiceImpl
     * @param violationRepository violation Repository
     */
    @Autowired
    public ViolationServiceImpl (ViolationRepository violationRepository) {
        this.violationRepository = violationRepository;
    }

    @Override
    public List<Violation> getAllViolation() {
        return violationRepository.findAll();
    }

    @Override
    public Optional<Violation> getViolationById(Long id) {
        return violationRepository.findById(id);
    }

    @Override
    public List<Violation> getAllViolationByStudentId(Long studentId) {
        return violationRepository.findByStudentId(studentId);
    }

    @Override
    public List<Violation> getAllViolationByStudentNumber(String studentNumber) {
        return violationRepository.findByStudentStudentNumber(studentNumber);
    }

    @Override
    public List<Violation> getViolationsByDateRange(Date startDate, Date endDate) {
        return violationRepository.findByDateOfNoticeBetween(startDate, endDate);
    }

    @Override
    public List<Violation> getAllViolationByStudentName(String name) {
        return violationRepository.findByStudentFirstNameContainingIgnoreCaseOrStudentMiddleNameContainingIgnoreCaseOrStudentLastNameContainingIgnoreCase(name, name, name);
    }
    @Override
    public void addViolation(Violation violation) {
        String offenseType = violation.getOffense().getType();
        Long studentId = violation.getStudent().getId();

        int previousOccurrences = violationRepository.countByStudentIdAndOffenseType(studentId, offenseType);
        int warningNumber = previousOccurrences + 1;
        violation.setWarningNumber(warningNumber);

        violationRepository.save(violation);
    }

    @Override
    public void updateViolation(Violation violation) {
        if (violationRepository.existsById(violation.getId())) {
            violationRepository.save(violation);
        } else {
            throw new IllegalArgumentException("Violation with ID " + violation.getId() + " not found.");
        }
    }
    @Override
    public List<Violation> getViolationByClusterName(String clusterName) {
        return violationRepository.findByClusterName(clusterName);
    }
}