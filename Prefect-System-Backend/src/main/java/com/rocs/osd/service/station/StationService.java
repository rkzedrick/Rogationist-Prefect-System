package com.rocs.osd.service.station;

import com.rocs.osd.domain.station.Station;

import java.util.List;
/**
 * Service interface for managing station operations, providing methods to retrieve
 * and manage station data.
 */
public interface StationService {
    /**
     * Retrieves all stations.
     *
     * @return list of all stations
     */
    List<Station> getAllStation();
}
