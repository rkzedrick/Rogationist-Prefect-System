package com.rocs.osd.service.csReport;

import com.rocs.osd.domain.csReport.CsReport;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing CsReport
 */
public interface CsReportService {

    /**
     * Retrieves all Community Service Reports.
     *
     * @return list of all CsReport
     */
    List<CsReport> getAllCsReport();

    /**
     * Retrieves Community Service Report by ID.
     *
     * @param id the ID of the report
     * @return CsReport
     */
    Optional<CsReport> getCsReportById(Long id);

    /**
     * Add a new Community Service Report.
     *
     * @param csReport CsReport to add
     */
    void addCsReport(CsReport csReport);
   }
