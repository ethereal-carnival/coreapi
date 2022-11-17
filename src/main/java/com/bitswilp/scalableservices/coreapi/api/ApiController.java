package com.bitswilp.scalableservices.coreapi.api;

import com.bitswilp.scalableservices.commonlibrary.communicationmodels.BedsAvailability;
import com.bitswilp.scalableservices.commonlibrary.communicationmodels.Statistics;
import com.bitswilp.scalableservices.coreapi.service.HospitalsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.bitswilp.scalableservices.commonlibrary.constants.URLs.BED_AVAILABILITY;
import static com.bitswilp.scalableservices.commonlibrary.constants.URLs.NEARBY_HOSPITALS;
import static com.bitswilp.scalableservices.commonlibrary.constants.URLs.STATS;

@RestController("api")
public class ApiController {

    private final HospitalsService hospitalsService;

    public ApiController(HospitalsService hospitalsService) {
        this.hospitalsService = hospitalsService;
    }

    @PostMapping(STATS)
    public Statistics getStats(@RequestParam String hospitalId) {
        return hospitalsService.getStats(hospitalId);
    }

    @PostMapping(BED_AVAILABILITY)
    public BedsAvailability getBedsAvailability(@RequestParam String hospitalId) {
        return hospitalsService.getBedsAvailability(hospitalId);
    }

    @PostMapping(NEARBY_HOSPITALS)
    public String getNearbyHospitals(@RequestParam String coordinates) {
        return hospitalsService.getNearbyHospitals(coordinates);
    }
}
