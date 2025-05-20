package com.rocs.osd.controller.section;

import com.rocs.osd.domain.section.Section;
import com.rocs.osd.service.section.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *RestController for managing section operation such as GET request.
 */
@RestController
@RequestMapping("/section")
public class SectionController {
    private SectionService sectionService;
    /**
     * This construct a new SectionController with the provided SectionService.
     *
     * @param sectionService this handle guest operations
     */
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }
    /**
     * Retrieves the list of all sections.
     *
     * @return The list of all sections
     */
    @GetMapping("/sectionList")
    public ResponseEntity<List<Section>> getAllSection() {
        return new ResponseEntity<>(sectionService.getAllSection(), HttpStatus.OK);
    }
    /**
     * Retrieves the list of clusterName.
     *
     * @param clusterName organization to retrieve
     * @return list of clusterName
     */
    @GetMapping("/clusterName/{clusterName}")
    public ResponseEntity<List<Section>> getSectionByClusterName(@PathVariable String clusterName) {
        List<Section> sections = sectionService.getSectionByClusterName(clusterName);
        return new ResponseEntity<>(sections, HttpStatus.OK);
    }
}
