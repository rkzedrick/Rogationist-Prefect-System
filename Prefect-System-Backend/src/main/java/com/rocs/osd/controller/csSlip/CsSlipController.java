package com.rocs.osd.controller.csSlip;

import com.rocs.osd.domain.csSlip.CsSlip;
import com.rocs.osd.service.csSlip.CsSlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 *RestController for managing Community Service Slip operation such as GET request.
 */
@RestController
@RequestMapping("/csSlip")
public class CsSlipController {

    private CsSlipService csSlipService;
    /**
     * Constructs a new CsSlipController with CsSlipService.
     *
     * @param csSlipService handles csSlip operations
     */
    @Autowired
    public CsSlipController (CsSlipService csSlipService) {
        this.csSlipService = csSlipService;
    }
    /**
     * Retrieves the list of all community service slip.
     *
     * @return The list of all community service slip
     */
    @GetMapping("/commServSlipList")
    public ResponseEntity<List<CsSlip>> getAllCsSlip(){
        return new ResponseEntity<>(csSlipService.getAllCsSlip(), HttpStatus.OK);
    }
    /**
     * Retrieves the community service slip by ID.
     *
     * @param id ID of the community service slip
     * @return List of CsSlip
     */
    @GetMapping("/commServSlip/{id}")
    public ResponseEntity<Optional<CsSlip>> getCsSlipById(@PathVariable Long id) {
        return new ResponseEntity<>(csSlipService.getCsSlipById(id), HttpStatus.OK);
    }
    /**
     * Retrieves the community service slip by Student Number.
     *
     * @param studentNumber student number of student
     * @return  List of CsSlip
     */
    @GetMapping("/studentNumber/{studentNumber}")
    public ResponseEntity<List<CsSlip>> getCsSlipByStudentNumber(@PathVariable String studentNumber) {
        return new ResponseEntity<>(this.csSlipService.getCsSlipByStudentNumber(studentNumber), HttpStatus.OK);
    }
    /**
     * Retrieves a community service slip by Student ID.
     *
     * @param studentId student ID of the student
     * @return  List of CsSlip
     */
    @GetMapping("/studentId/{studentId}")
    public ResponseEntity<List<CsSlip>> getCsSlipByStudentId(@PathVariable Long studentId) {
        return new ResponseEntity<>(this.csSlipService.getCsSlipByStudentId(studentId), HttpStatus.OK);
    }
    /**
     * Retrieves the total hours of community service by Student ID.
     *
     * @param studentNumber ID of the student
     * @return  List of CsSlip Total hours
     */
    @GetMapping("/totalCsHours/{studentNumber}")
    public ResponseEntity<Integer> getTotalCsHoursByStudent(@PathVariable String studentNumber) {
        int totalCsHours = csSlipService.getTotalCsHoursByStudent(studentNumber);
        return new ResponseEntity<>(totalCsHours, HttpStatus.OK);
    }
    /**
     * Retrieves a community service slip by Student name.
     *
     * @param name name of the student
     * @return List of CsSlip
     */
    @GetMapping("/commServSlipsByName/{name}")
    public ResponseEntity<List<CsSlip>> getCsSlipsByStudentName(@PathVariable String name) {
        List<CsSlip> csSlips = csSlipService.getCsSlipByStudentName(name);
        if (!csSlips.isEmpty()) {
            return new ResponseEntity<>(csSlips, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Retrieves a community service slip report by Student name.
     *
     * @param name name of the student
     * @return List of CsSlipReport
     */
    @GetMapping("/commServReportByName/{name}")
    public ResponseEntity<List<CsSlip>> getCsSlipReportByStudentName(@PathVariable String name) {
        List<CsSlip> csSlips = csSlipService.getCsSlipReportByStudentName(name);
        if (!csSlips.isEmpty()) {
            return new ResponseEntity<>(csSlips, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Retrieves the area of community service slip by name.
     *
     * @param name name of the station
     * @return List of CsSlip
     */
    @GetMapping("/areaOfCs/{name}")
    public ResponseEntity<List<CsSlip>> getCsSlipReportByStationName(@PathVariable String name) {
        List<CsSlip> csSlips = csSlipService.getCsSlipReportByStationName(name);
        if (!csSlips.isEmpty()) {
            return new ResponseEntity<>(csSlips, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Updates the deduction for a community service slip.
     *
     * @param csSlipId ID of community service slip
     * @param deduction deduction to update
     */
    @PutMapping("/updateDeduction/{csSlipId}")
    public ResponseEntity<String> updateDeduction(@PathVariable Long csSlipId, @RequestParam int deduction) {
        try {
            csSlipService.updateDeduction(csSlipId, deduction);
            return new ResponseEntity<>("Deduction updated successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update deduction: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Add a new community service slip.
     *
     * @param csSlip community service slip to be added
     */
    @PostMapping("/addCsSlip")
    public ResponseEntity<String> addCsSlip(@RequestBody CsSlip csSlip){
        try {
            csSlipService.addCsSlip(csSlip);
            return new ResponseEntity<>("Community Service Slip successfully added", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Community Service Slip cannot be added", HttpStatus.OK);
        }
    }
    /**
     * Retrieve community service slips by the cluster name of the student's section.
     *
     * @param clusterName the name of the cluster
     * @return a ResponseEntity containing a list of CsSlips and an HTTP status
     */
    @GetMapping("/clusterName/{clusterName}")
    public ResponseEntity<List<CsSlip>> getCsSlipByClusterName(@PathVariable String clusterName) {
        try {
            List<CsSlip> csSlips = csSlipService.getCsSlipByClusterName(clusterName);
            return new ResponseEntity<>(csSlips, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
