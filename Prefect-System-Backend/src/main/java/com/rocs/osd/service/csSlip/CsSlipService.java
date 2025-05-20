package com.rocs.osd.service.csSlip;

import com.rocs.osd.domain.csReport.CsReport;
import com.rocs.osd.domain.csSlip.CsSlip;

import java.util.List;
import java.util.Optional;
/**
 * Service interface for managing CsSlip
 */
public interface CsSlipService {
    /**
     * Retrieves all Community Service Slips.
     *
     * @return list of all CsSlip
     */
    List<CsSlip> getAllCsSlip();
    /**
     * Retrieves a Community Service Slip by ID.
     *
     * @param id the ID of the slip
     * @return CsSlip
     */
    Optional<CsSlip> getCsSlipById(Long id);
    /**
     * Retrieves Community Service Slips by the student name.
     *
     * @param name student name
     * @return list of CsSlip
     */
    List<CsSlip> getCsSlipByStudentName(String name);
    /**
     * Retrieves Community Service Slips by the student number.
     *
     * @param studentNumber student number
     * @return list of CsSlip
     */
    List<CsSlip> getCsSlipByStudentNumber(String studentNumber);
    /**
     * Retrieves Community Service Slips by the student ID.
     *
     * @param studentId student ID
     * @return list  CsSlip
     */
    List<CsSlip> getCsSlipByStudentId(Long studentId);
    /**
     * Retrieves Community Service Slips report by the student name.
     *
     * @param name student name
     * @return a list of CsSlip
     */
    List<CsSlip> getCsSlipReportByStudentName(String name);
    /**
     * Retrieves Community Service Slips report by the station name.
     *
     * @param name name of the station
     */
    List<CsSlip> getCsSlipReportByStationName(String name);
    /**
     * Adds a new Community Service Slip.
     *
     * @param csSlip CsSlip to add
     */
    CsSlip addCsSlip(CsSlip csSlip);
    /**
     * Calculates the total community service hours
     *
     * @param studentNumber student ID
     * @return total number of community service hours for student
     */
    int getTotalCsHoursByStudent(String studentNumber);
    /**
     * Updates the deduction amount for a Community Service Slip.
     *
     * @param csSlipId CsSlip ID
     * @param deduction the deduction amount to update
     */
    void updateDeduction(Long csSlipId, int deduction);
    /**
     * Add a Community Service Report to a Community Service Slip.
     *
     * @param csSlipId CsSlip ID
     * @param csReport CsReport to add
     * @return the updated CsSlip with the added report
     */
    CsReport addCsReportToCsSlip(Long csSlipId, CsReport csReport);
    /**
     * Retrieves violations filtered by the given clusterName.
     *
     * @param clusterName the cluster to filter by (CETE or CEBAM)
     * @return list of violations related to the specified clusterName
     */
    List<CsSlip> getCsSlipByClusterName(String clusterName);

}