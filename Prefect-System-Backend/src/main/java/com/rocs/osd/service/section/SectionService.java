package com.rocs.osd.service.section;

import com.rocs.osd.domain.section.Section;

import java.util.List;
/**
 * Service interface for managing section operations, providing methods to retrieve
 * and manage section data.
 */
public interface SectionService {
    /**
     * Retrieves all sections.
     *
     * @return list of all section
     */
    List<Section> getAllSection();
    /**
     * Retrieves section by cluster.
     *
     * @param clusterName of the section
     * @return a list of cluster
     */
    List<Section> getSectionByClusterName(String clusterName);
}
