package com.rocs.osd.controller.violation;

import com.rocs.osd.domain.violationList.ViolationList;
import com.rocs.osd.domain.violation.Violation;
import com.rocs.osd.service.violation.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *RestController for managing violation operations such as GET, POST and PUT requests.
 */

@RestController
@RequestMapping("/violation")
public class ViolationController {
    private ViolationService violationService;

    /**
     * Constructs a new ViolationController with ViolationService.
     *
     * @param violationService violation operations
     */
    @Autowired
    public ViolationController(ViolationService violationService) {
        this.violationService = violationService;
    }

    /**
     * Retrieves the list of all violations.
     *
     * @return list of all violations
     */
    @GetMapping("/violationList")
    public ResponseEntity<List<Violation>> getAllViolation() {
        return new ResponseEntity<>(violationService.getAllViolation(), HttpStatus.OK);
    }

    /**
     * Retrieves the list of violations by employeeId.
     *
     * @param id employeeId of the employee
     * @return list of violations
     */
    @GetMapping("/violationId/{id}")
    public ResponseEntity<Optional<Violation>> getViolationById(@PathVariable Long id) {
        return new ResponseEntity<>(this.violationService.getViolationById(id), HttpStatus.OK);
    }

    /**
     * Retrieves the list of violations by studentId.
     *
     * @param studentId studentId of the student
     * @return list of violations
     */
    @GetMapping("/studentId/{studentId}")
    public ResponseEntity<List<Violation>> getAllViolationByStudentId(@PathVariable Long studentId) {
        return new ResponseEntity<>(this.violationService.getAllViolationByStudentId(studentId), HttpStatus.OK);
    }

    /**
     * Retrieves the list of violations by studentNumber.
     *
     * @param studentNumber studentNumber of the student
     * @return list of violations
     */
    @GetMapping("/studentNumber/{studentNumber}")
    public ResponseEntity<List<Violation>> getAllViolationByStudentNumber(@PathVariable String studentNumber) {
        return new ResponseEntity<>(this.violationService.getAllViolationByStudentNumber(studentNumber), HttpStatus.OK);
    }

    /**
     * Retrieves the list of violations by student name.
     *
     * @param name the name of the student
     * @return list of violations where the student's name matches
     */
    @GetMapping("/studentName/{name}")
    public ResponseEntity<List<Violation>> getAllViolationByStudentName(@PathVariable String name) {
        return new ResponseEntity<>(violationService.getAllViolationByStudentName(name), HttpStatus.OK);
    }

    /**
     * Retrieves the list of violations within a specific date range
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return list of violations within the date range
     */
    @GetMapping("/date-range")
    public ResponseEntity<List<Violation>> getViolationsByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return new ResponseEntity<>(this.violationService.getViolationsByDateRange(startDate, endDate), HttpStatus.OK);
    }

    /**
     * Adds a new violation
     *
     * @param violation Violation to be added.
     * @return a success message if adding is successful, or an error message if the addition fails.
     */
    @PostMapping("/addViolation")
    public ResponseEntity<Violation> addViolation(@RequestBody Violation violation) {
        try {
            violationService.addViolation(violation);
            return new ResponseEntity<>(violation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Updates an existing violation
     *
     * @param violation Violation containing updated information.
     * @return a success message if update is successful or an error message if the update fails.
     */
    @PutMapping("/updateViolation")
    public ResponseEntity<String> updateViolation(@RequestBody Violation violation) {
        try {
            violationService.updateViolation(violation);
            return new ResponseEntity<>("Violation successfully updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Violation not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/listOfViolation/{studentNumber}")
    public ResponseEntity<ViolationList> getAllViolationsByStudentNumber(@PathVariable String studentNumber) {
        List<Violation> violations = this.violationService.getAllViolationByStudentNumber(studentNumber);
        ViolationList sample = new ViolationList();
        sample.setStudentId(violations.get(0).getStudent().getId());
        sample.setOffense(violations.get(0).getOffense());
        return new ResponseEntity<>(sample, HttpStatus.OK);
    }
    /**
     * Retrieve community service slips by the cluster name of the student's section.
     *
     * @param clusterName the name of the cluster
     * @return a ResponseEntity containing a list of CsSlips and an HTTP status
     */
    @GetMapping("/clusterName/{clusterName}")
    public ResponseEntity<List<Violation>> getViolationByClusterName(@PathVariable String clusterName) {
        try {
            List<Violation> violations = violationService.getViolationByClusterName(clusterName);
            return new ResponseEntity<>(violations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}