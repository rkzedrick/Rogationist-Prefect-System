package com.rocs.osd.service.section.impl;

import com.rocs.osd.domain.section.Section;
import com.rocs.osd.repository.section.SectionRepository;
import com.rocs.osd.service.section.SectionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of Section interface that interacts with the SectionRepository
 * to retrieve and manage section data from the database
 */
@Service
public class SectionServiceImpl implements SectionService {
    private SectionRepository sectionRepository;
    /**
     * Constructs an instance of SectionServiceImpl
     * @param sectionRepository offense Repository
     */
    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public List<Section> getAllSection() {
        return sectionRepository.findAll();
    }

    @Override
    public List<Section> getSectionByClusterName(String clusterName) {
        return sectionRepository.getSectionByClusterName(clusterName);
    }
}
