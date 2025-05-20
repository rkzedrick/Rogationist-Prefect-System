package com.rocs.osd.repository.csReport;

import com.rocs.osd.domain.csReport.CsReport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * An interface to the Community Service Report repository.
 */
public interface CsReportRepository extends JpaRepository<CsReport, Long> {
}
