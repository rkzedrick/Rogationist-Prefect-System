package com.rc.porms.appl.model.violation;


import com.rc.porms.appl.model.employee.Employee;
import com.rc.porms.appl.model.offense.Offense;
import com.rc.porms.appl.model.student.Student;

import java.sql.Timestamp;

/**
 * Represents a record of a student violation.
 */
public class Violation {
    private int id;
    private Student student;
    private Offense offense;
    private int warningNum;
    private int commServHours;
    private String disciplinaryAction;
    private Timestamp dateOfNotice;
    private Employee approvedBy;
    private String studentName;
    private int offenseId;
    private int approvedById;
    private int studentId;


    /**
     * Constructs a new Violation object.
     *
     * @param id        The unique identifier of the violation record.
     * @param student   The student who committed the violation.
     * @param offense   The offense associated with the violation.
     * @param warningNum    The number of occurrence the offense was violated.
     * @param commServHours   The community service hours of the violated offense.
     * @param disciplinaryAction    The disciplinary action of the violated offense.
     * @param dateOfNotice   The timestamp indicating the date and time of the violation.
     * @param approvedBy   The personnel approving the notice of violation.
     */

    public Violation(int id, Student student, Offense offense, int commServHours, int warningNum, String disciplinaryAction, Timestamp dateOfNotice, Employee approvedBy, String studentName, int offenseId, int approvedById, int studentId) {
        this.id = id;
        this.student = student;
        this.offense = offense;
        this.commServHours = commServHours;
        this.warningNum = warningNum;
        this.disciplinaryAction = disciplinaryAction;
        this.dateOfNotice = dateOfNotice;
        this.approvedBy = approvedBy;
        this.studentName = studentName;
        this.offenseId = offenseId;
        this.approvedById = approvedById;
        this.studentId = studentId;
    }

    /**
     * Constructs a new Violation object with default values.
     */
    public Violation() {
    }

    /**
     * Retrieves the unique identifier of the Violation record.
     * @return The unique identifier of the Violation record.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the Violation record.
     * @param id The unique identifier to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the student object of the Student associated with the Violation.
     * @return The student object of the Student.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the student indicating the student of the Violation.
     * @param student The student to set.
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Retrieves the offense object of the Offense associated with the Violation.
     * @return The offense object of the Violation.
     */
    public Offense getOffense() {
        return offense;
    }

    /**
     * Sets the Violation indicating the violation of the offense.
     * @param offense The Offense to set.
     */
    public void setOffense(Offense offense) {
        this.offense = offense;
    }

    /**
     * Retrieves the warningNum of the Violation.
     * @return The warningNum of the Violation.
     */
    public int getWarningNum() {
        return warningNum;
    }

    /**
     * Sets the warningNum of the Violation.
     * @param warningNum The warningNum to set.
     */
    public void setWarningNum(int warningNum) {
        this.warningNum = warningNum;
    }

    /**
     * Retrieves the commServHours of the Violation.
     * @return The commServHours of the Violation.
     */
    public int getCommServHours() {
        return commServHours;
    }

    /**
     * Sets the commServHours of the Violation.
     * @param commServHours The commServHours to set.
     */
    public void setCommServHours(int commServHours) {
        this.commServHours = commServHours;
    }

    /**
     * Retrieves the disciplinaryAction of the Violation.
     * @return The disciplinaryAction of the Violation.
     */
    public String getDisciplinaryAction() {
        return disciplinaryAction;
    }

    /**
     * Sets the disciplinaryAction of the Violation.
     * @param disciplinaryAction The disciplinaryAction to set.
     */
    public void setDisciplinaryAction(String disciplinaryAction) {
        this.disciplinaryAction = disciplinaryAction;
    }

    /**
     * Retrieves the timestamp indicating the date and time of the Violation.
     * @return The timestamp indicating the date and time of the Violation.
     */
    public Timestamp getDateOfNotice() {
        return dateOfNotice;
    }

    /**
     * Sets the timestamp indicating the date and time of the Violation.
     * @param dateOfNotice The timestamp to set.
     */
    public void setDateOfNotice(Timestamp dateOfNotice) {
        this.dateOfNotice = dateOfNotice;
    }

    /**
     * Retrieves the approvedBy of the Violation.
     * @return The approvedBy of the Violation.
     */
    public Employee getApprovedBy() {
        return approvedBy;
    }

    /**
     * Sets the approvedBy indicating the personnel who approve the Violation.
     * @param approvedBy The approvedBy to set.
     */
    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }

    /**
     * Retrieves the ID of the student associated with the violation.
     *
     * @return The unique identifier of the student.
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets the ID of the student associated with the violation.
     *
     * @param studentId The unique identifier of the student.
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Retrieves the ID of the offense committed by the student.
     *
     * @return The unique identifier of the offense.
     */
    public int getOffenseId() {
        return offenseId;
    }

    /**
     * Sets the ID of the offense committed by the student.
     *
     * @param offenseId The unique identifier of the offense.
     */
    public void setOffenseId(int offenseId) {
        this.offenseId = offenseId;
    }

    /**
     * Retrieves the name of the student associated with the violation.
     *
     * @return The name of the student.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the name of the student associated with the violation.
     *
     * @param studentName The name of the student.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Retrieves the ID of the personnel who approved the violation.
     *
     * @return The unique identifier of the approver.
     */
    public int getApprovedById() {
        return approvedById;
    }

    /**
     * Sets the ID of the personnel who approved the violation.
     *
     * @param approvedById The unique identifier of the approver.
     */
    public void setApprovedById(int approvedById) {
        this.approvedById = approvedById;
    }

}
