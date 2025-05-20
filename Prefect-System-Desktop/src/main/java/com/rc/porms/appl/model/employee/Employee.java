package com.rc.porms.appl.model.employee;


import java.sql.Timestamp;

/**
 * Employee model class representing employee information.
 */
public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String positionInRC;
    private Timestamp dateEmployed;
    private Timestamp birthdate;
    private String birthplace;
    private String sex;
    private String address;
    private String contactNo;
    private String civilStatus;
    private String citizenship;
    private String religion;
    private String email;
    private String sssNo;
    private String tinNo;
    private String pagibigNo;
    private String employeeNo;
    private int stationId;

    /**
     * Default constructor for Employee.
     */

    public Employee(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the last name of the employee.
     * @return The last name of the employee.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the employee.
     * @param lastName The last name of the employee.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the first name of the employee.
     * @return The first name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the employee.
     * @param firstName The first name of the employee.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the middle name of the employee.
     * @return The middle name of the employee.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Set the middle name of the employee.
     * @param middleName The middle name of the employee.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Get the position of the employee in the organization.
     * @return The position of the employee.
     */
    public String getPositionInRC() {
        return positionInRC;
    }

    /**
     * Set the position of the employee in the organization.
     * @param positionInRC The position of the employee.
     */
    public void setPositionInRC(String positionInRC) {
        this.positionInRC = positionInRC;
    }

    /**
     * Get the date when the employee was employed.
     * @return The date of employment.
     */
    public Timestamp getDateEmployed() {
        return dateEmployed;
    }

    /**
     * Set the date when the employee was employed.
     * @param dateEmployed The date of employment.
     */
    public void setDateEmployed(Timestamp dateEmployed) {
        this.dateEmployed = dateEmployed;
    }

    /**
     * Get the birthdate of the employee.
     * @return The birthdate of the employee.
     */
    public Timestamp getBirthdate() {
        return birthdate;
    }

    /**
     * Set the birthdate of the employee.
     * @param birthdate The birthdate of the employee.
     */
    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Get the birthplace of the employee.
     * @return The birthplace of the employee.
     */
    public String getBirthplace() {
        return birthplace;
    }

    /**
     * Set the birthplace of the employee.
     * @param birthplace The birthplace of the employee.
     */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    /**
     * Get the gender of the employee.
     * @return The gender of the employee.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Set the gender of the employee.
     * @param sex The gender of the employee.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Get the civil status of the employee.
     * @return The civil status of the employee.
     */
    public String getCivilStatus() {
        return civilStatus;
    }

    /**
     * Set the civil status of the employee.
     * @param civilStatus The civil status of the employee.
     */
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    /**
     * Get the citizenship of the employee.
     * @return The citizenship of the employee.
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     * Set the citizenship of the employee.
     * @param citizenship The citizenship of the employee.
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     * Get the religion of the employee.
     * @return The religion of the employee.
     */
    public String getReligion() {
        return religion;
    }

    /**
     * Set the religion of the employee.
     * @param religion The religion of the employee.
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * Get the email address of the employee.
     * @return The email address of the employee.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the employee.
     * @param email The email address of the employee.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the Social Security System (SSS) number of the employee.
     * @return The SSS number of the employee.
     */
    public String getSssNo() {
        return sssNo;
    }

    /**
     * Set the Social Security System (SSS) number of the employee.
     * @param sssNo The SSS number of the employee.
     */
    public void setSssNo(String sssNo) {
        this.sssNo = sssNo;
    }

    /**
     * Get the Tax Identification Number (TIN) of the employee.
     * @return The TIN of the employee.
     */
    public String getTinNo() {
        return tinNo;
    }

    /**
     * Set the Tax Identification Number (TIN) of the employee.
     * @param tinNo The TIN of the employee.
     */
    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    /**
     * Get the Pag-IBIG Fund number of the employee.
     * @return The Pag-IBIG Fund number of the employee.
     */
    public String getPagibigNo() {
        return pagibigNo;
    }

    /**
     * Set the Pag-IBIG Fund number of the employee.
     * @param pagibigNo The Pag-IBIG Fund number of the employee.
     */
    public void setPagibigNo(String pagibigNo) {
        this.pagibigNo = pagibigNo;
    }

    /**
     * Get the employee number of the employee.
     * @return The employee number of the employee.
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * Set the employee number of the employee.
     * Validation for employee no. should have a pattern.
     * @param employeeNo The employee number of the employee.
     * @return true if the employee number is valid, false otherwise.
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * Get the employee number of the employee.
     * @return The employee address of the employee.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the employee number of the employee.
     * Validation for employee no. should have a pattern.
     * @param address The employee address of the employee.
     * @return true if the employee address is valid, false otherwise.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the employee Contact number of the employee.
     * @return The employee Contact number of the employee.
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * Set the employee number of the employee.
     * Validation for employee no. should have a pattern.
     * @param contactNo The employee Contact number of the employee.
     * @return true if the employee Contact number is valid, false otherwise.
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * Get the station ID associated with the user.
     * @return The station ID of the user.
     */
    public int getStationId() {
        return stationId;
    }

    /**
     * Set the station ID for the user.
     * This can be used to associate the user with a specific station.
     * @param stationId The station ID to be assigned to the user.
     */
    public void setStationId(int stationId) {
        this.stationId = stationId;
    }
}
