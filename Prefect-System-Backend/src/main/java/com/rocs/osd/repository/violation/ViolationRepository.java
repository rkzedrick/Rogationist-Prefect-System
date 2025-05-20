package com.rocs.osd.repository.violation;

import com.rocs.osd.domain.violation.Violation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

/**
 * An interface to the Violation repository.
 */
public interface
ViolationRepository extends JpaRepository<Violation, Long> {

    /**
     * Finds list of violations by studentId.
     *
     * @param studentId studentId of the violation
     * @return list of violation with the studentId
     */
    List<Violation> findByStudentId(Long studentId);

    /**
     * Finds list of violations by studentNumber.
     *
     * @param studentStudentNumber studentStudentNumber of the violation
     * @return list of violation with the studentNumber
     */
    List<Violation> findByStudentStudentNumber(String studentStudentNumber);

    /**
     * Finds a list of violations within a specified date range.
     *
     * @param startDate start date of the range.
     * @param endDate end date of the range.
     * @return list of violations that occurred between the start and end dates.
     */
    @Query("SELECT v FROM Violation v WHERE v.dateOfNotice BETWEEN :startDate AND :endDate")
    List<Violation> findByDateOfNoticeBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    /**
     * Finds list of violations by student specific firstName, middleName, and lastName.
     *
     * @param firstName firstName of the student
     * @param middleName middleName of the student
     * @param lastName lastName of the student
     * @return list of violation with the specific firstName, middleName, and lastName.
     */
    List<Violation> findByStudentFirstNameContainingIgnoreCaseOrStudentMiddleNameContainingIgnoreCaseOrStudentLastNameContainingIgnoreCase(String firstName, String middleName, String lastName);

    /**
     * Finds a list of violations within a specified date range.
     *
     * @param offenseType offense type.
     * @param studentId of the student.
     * @return total of violations that occurred between the start and end dates.
     */
    @Query("SELECT COUNT(v) FROM Violation v WHERE v.student.Id = :studentId AND v.offense.type = :offenseType")
    int countByStudentIdAndOffenseType(@Param("studentId") Long studentId, @Param("offenseType") String offenseType);
    /**
     * Finds CsSlips by the cluster name of the student's section.
     *
     * @param clusterName the name of the cluster
     * @return list of CsSlips associated with the given cluster name
     */

    @Query("SELECT cs FROM Violation cs " + "JOIN cs.student st " + "JOIN st.section sec " + "WHERE sec.clusterName = :clusterName")
    List<Violation> findByClusterName(@Param("clusterName") String clusterName);
}