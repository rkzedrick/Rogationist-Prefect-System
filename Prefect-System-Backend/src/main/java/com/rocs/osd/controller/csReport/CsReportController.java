package com.rocs.osd.controller.csReport;

import com.rocs.osd.domain.csReport.CsReport;
import com.rocs.osd.domain.violation.Violation;
import com.rocs.osd.service.csReport.CsReportService;
import com.rocs.osd.service.csSlip.CsSlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *RestController for managing Community Service Report operation such as GET and POST request.
 */
@RestController
@RequestMapping("/csreport")
public class CsReportController {
    private CsReportService csReportService;
    private CsSlipService csSlipService;

    /**
     * This construct a new CsReportController with the provided CsReportService and CsSlipService.
     *
     * @param csReportService handles community service report
     * @param csSlipService handles community service slip
     */
    @Autowired
    public CsReportController(CsReportService csReportService, CsSlipService csSlipService) {
        this.csReportService = csReportService;
        this.csSlipService = csSlipService;
    }
    /**
     * Retrieves the list of all community service reports.
     *
     * @return The list of all community service reports
     */
    @GetMapping("/csReportList")
    public ResponseEntity<List<CsReport>> getAllCsReport() {
        return new ResponseEntity<>(csReportService.getAllCsReport(), HttpStatus.OK);
    }
    /**
     * Retrieves community service report by ID.
     *
     * @param id ID of the community service report to retrieve
     * @return  The CsReport
     */
    @GetMapping("/csReportId/{id}")
    public ResponseEntity<Optional<CsReport>> getCsReportById(@PathVariable Long id) {
        return new ResponseEntity<>(this.csReportService.getCsReportById(id), HttpStatus.OK);
    }
    /**
     * Add a new community service report.
     *
     * @param csReport the CsReport containing the details of the report to be added
     */
    @PostMapping("/addCsReport")
    public ResponseEntity<String> addCsReport(@RequestBody CsReport csReport){
        try {
            csReportService.addCsReport(csReport);
            return new ResponseEntity<>("CS Report successfully added", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("CS Report cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Add a new community service report to a specific community service slip.
     *
     * @param csSlipId ID of the community service slip to which the report will be added
     * @param csReport CsReport containing the details of the report to be added
     * @return The created CsReport
     */
    @PostMapping("/addCsReportForSlip/{csSlipId}")
    public ResponseEntity<CsReport> addCsReport(@PathVariable Long csSlipId, @RequestBody CsReport csReport) {
        CsReport createdReport = csSlipService.addCsReportToCsSlip(csSlipId, csReport);
        return new ResponseEntity<>(createdReport, HttpStatus.OK);
    }

}
