package com.rocs.osd.domain.violationList;

import com.rocs.osd.domain.offense.Offense;
import lombok.Data;

/**
 * Represents the Sample entity.
 */
@Data
public class ViolationList {

    private Long studentId;
    private Offense offense;
}
