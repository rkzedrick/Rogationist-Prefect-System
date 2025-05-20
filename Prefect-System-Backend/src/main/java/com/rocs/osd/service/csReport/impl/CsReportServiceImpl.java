package com.rocs.osd.service.csReport.impl;

import com.rocs.osd.domain.csReport.CsReport;
import com.rocs.osd.repository.csReport.CsReportRepository;
import com.rocs.osd.service.csReport.CsReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Implementation of CsReportService interface.
 */
@Service
public class CsReportServiceImpl implements CsReportService {
    private CsReportRepository csReportRepository;

    @Autowired
    public CsReportServiceImpl(CsReportRepository csReportRepository) {
        this.csReportRepository = csReportRepository;
    }

    @Override
    public List<CsReport> getAllCsReport() {
        return csReportRepository.findAll();
    }

    @Override
    public Optional<CsReport> getCsReportById(Long id) {
        return csReportRepository.findById(id);
    }

    @Override
    public void addCsReport(CsReport csReport) {
        csReportRepository.save(csReport);
    }

}