package com.rocs.osd.repository.section;

import com.rocs.osd.domain.section.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * An interface to the Section repository.
 */
public interface SectionRepository extends JpaRepository<Section, Long> {
    /**
     * Finds list of section by their cluster.
     *
     * @param clusterName of section
     * @return a list of sections with the specified clusterName
     */
    List<Section> getSectionByClusterName(String clusterName);
}
