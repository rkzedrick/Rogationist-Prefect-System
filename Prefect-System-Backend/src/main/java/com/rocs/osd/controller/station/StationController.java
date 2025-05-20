package com.rocs.osd.controller.station;

import com.rocs.osd.domain.station.Station;
import com.rocs.osd.service.station.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 *RestController for managing station operation such as GET request.
 */
@RestController
@RequestMapping("/station")
public class StationController {
    private StationService stationService;
    /**
     * This construct a new StationController with the provided StationService.
     *
     * @param stationService this handle guest operations
     */
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }
    /**
     * Retrieves the list of all stations.
     *
     * @return The list of all stations
     */
    @GetMapping("/stationList")
    public ResponseEntity<List<Station>> getAllStation() {
        return new ResponseEntity<>(stationService.getAllStation(), HttpStatus.OK);
    }
}
