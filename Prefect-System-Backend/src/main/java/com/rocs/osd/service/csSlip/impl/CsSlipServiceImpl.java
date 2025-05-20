package com.rocs.osd.service.csSlip.impl;

import com.rocs.osd.domain.csReport.CsReport;
import com.rocs.osd.domain.csSlip.CsSlip;
import com.rocs.osd.domain.student.Student;
import com.rocs.osd.domain.violation.Violation;
import com.rocs.osd.exception.ResourceNotFoundException;
import com.rocs.osd.repository.csReport.CsReportRepository;
import com.rocs.osd.repository.csSlip.CsSlipRepository;
import com.rocs.osd.repository.student.StudentRepository;
import com.rocs.osd.repository.violation.ViolationRepository;
import com.rocs.osd.service.csSlip.CsSlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of CsSlip interface that interacts with the CsSlipRepository
 * to retrieve and manage csSlip data from the database
 */
@Service
public class CsSlipServiceImpl implements CsSlipService {
    private CsSlipRepository csSlipRepository;
    private StudentRepository studentRepository;
    private ViolationRepository violationRepository;
    private CsReportRepository csReportRepository;

    /**
     * This is a constructor for injecting the CsSlipRepository.
     *
     * @param csSlipRepository accessing csSlip data
     * @param violationRepository accessing violation data
     * @param studentRepository accessing student data
     */
    @Autowired
    public CsSlipServiceImpl(CsSlipRepository csSlipRepository, StudentRepository studentRepository, ViolationRepository violationRepository, CsReportRepository csReportRepository) {
        this.csSlipRepository = csSlipRepository;
        this.violationRepository = violationRepository;
        this.studentRepository = studentRepository;
        this.csReportRepository = csReportRepository;
    }

    @Override
    public List<CsSlip> getAllCsSlip() {
        return csSlipRepository.findAll();
    }

    @Override
    public Optional<CsSlip> getCsSlipById(Long id) {
        return csSlipRepository.findById(id);
    }

    @Override
    public int getTotalCsHoursByStudent(String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber);
        if (student != null) {
            List<Violation> violations = violationRepository.findByStudentStudentNumber(studentNumber);
            return violations.stream().mapToInt(Violation::getCsHours).sum();
        } else {
            throw new IllegalArgumentException("Student not found with number: " + studentNumber);
        }
    }

    @Override
    public void updateDeduction(Long csSlipId, int deduction) {
        CsSlip csSlip = csSlipRepository.findById(csSlipId)
                .orElseThrow(() -> new RuntimeException("CS Slip not found with id " + csSlipId));

        csSlip.setDeduction(deduction);
        csSlipRepository.save(csSlip);
    }

    @Override
    public CsSlip addCsSlip(CsSlip csSlip) {
        return csSlipRepository.save(csSlip); }

    @Override
    public List<CsSlip> getCsSlipByStudentName(String name) {
        List<CsSlip> csSlips = csSlipRepository.findByStudent_FirstNameContainingOrStudent_MiddleNameContainingOrStudent_LastNameContaining(name, name, name);
        return csSlips;
    }

    @Override
    public List<CsSlip> getCsSlipByStudentNumber(String studentNumber) {
        return csSlipRepository.findByStudentStudentNumber(studentNumber);
    }

    @Override
    public List<CsSlip> getCsSlipByStudentId(Long studentId) {
        return csSlipRepository.findByStudent_Id(studentId);
    }

    @Override
    public List<CsSlip> getCsSlipReportByStudentName(String name) {
        List<CsSlip> csSlips = csSlipRepository.findByStudent_FirstNameContainingOrStudent_MiddleNameContainingOrStudent_LastNameContaining(name, name, name);

        return csSlips;
    }

    @Override
    public List<CsSlip> getCsSlipReportByStationName(String name) {
        return csSlipRepository.findByAreaOfCommServ_StationNameIgnoreCase(name);
    }
    @Transactional
    public CsReport addCsReportToCsSlip(Long csSlipId, CsReport csReport) {
        CsSlip csSlip = csSlipRepository.findById(csSlipId)
                .orElseThrow(() -> new ResourceNotFoundException("CsSlip not found"));
        csSlip.addReport(csReport);
        csSlipRepository.save(csSlip);
        return csReportRepository.save(csReport);
    }

    @Override
    public List<CsSlip> getCsSlipByClusterName(String clusterName) {
        return csSlipRepository.findByClusterName(clusterName);
    }
}