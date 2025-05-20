package com.rocs.osd.service.violation;

import com.rocs.osd.domain.violation.Violation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing violation operations, providing methods to retrieve
 * and manage violation data.
 */
public interface ViolationService {

    /**
     * Retrieves all violations.
     *
     * @return list of all violations
     */
    List<Violation> getAllViolation();
    /**
     * Retrieves violations by violationId.
     *
     * @param  id id of violation
     * @return list of violation
     */
    Optional<Violation> getViolationById(Long id);

    /**
     * Retrieves violations by studentId.
     *
     * @param studentId ID of the student whose violations are being retrieved.
     * @return  list of violations with the student ID.
     */
    List<Violation> getAllViolationByStudentId(Long studentId);

    /**
     * Retrieves violations by student number.
     *
     * @param studentNumber studentNumber whose violations are being retrieved.
     * @return list of violations with student number.
     */
    List<Violation> getAllViolationByStudentNumber(String studentNumber);

    /**
     *  Retrieves violations by student's name
     *
     * @param name name of the student
     * @return list of violations where the student's name matches the given value.
     */
    List<Violation> getAllViolationByStudentName(String name);

    /**
     * Retrieves violations within a specified date range
     *
     * @param startDate the start date of the range.
     * @param endDate the end date of the range.
     * @return list of violations occurred between the start and end dates.
     */
    List<Violation> getViolationsByDateRange(Date startDate, Date endDate);

    /**
     *   Adds a new violation
     *
     * @param violation violation to be added.
     */
    void addViolation(Violation violation);

    /**
     *  Updates an existing violation
     *
     * @param violation  violation updated information.
     */
    void updateViolation(Violation violation);
    /**
     * Retrieves violations filtered by the given clusterName.
     *
     * @param clusterName the cluster to filter by (CETE or CEBAM)
     * @return list of violations related to the specified clusterName
     */
    List<Violation> getViolationByClusterName(String clusterName);
}