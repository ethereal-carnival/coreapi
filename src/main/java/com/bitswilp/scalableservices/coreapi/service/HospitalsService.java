package com.bitswilp.scalableservices.coreapi.service;

import com.bitswilp.scalableservices.commonlibrary.communicationmodels.BedsAvailability;
import com.bitswilp.scalableservices.commonlibrary.communicationmodels.Statistics;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.bitswilp.scalableservices.commonlibrary.constants.URLs.BED_AVAILABILITY;
import static com.bitswilp.scalableservices.commonlibrary.constants.URLs.NEARBY_HOSPITALS;
import static com.bitswilp.scalableservices.commonlibrary.constants.URLs.STATS;
import static com.bitswilp.scalableservices.commonlibrary.constants.URLs.URL_COMPONENT_GET;
import static com.bitswilp.scalableservices.commonlibrary.constants.URLs.getBedsAvailabilityUrl;
import static com.bitswilp.scalableservices.commonlibrary.constants.URLs.getNearbyHospitalsUrl;
import static com.bitswilp.scalableservices.commonlibrary.constants.URLs.getStatsUrl;

@Service
public class HospitalsService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Statistics getStats(String hospitalId) {
        String url = getStatsUrl() + URL_COMPONENT_GET + STATS;
        ResponseEntity<Statistics> response = restTemplate.postForEntity(url, hospitalId, Statistics.class);
        return response.getBody();
    }

    public BedsAvailability getBedsAvailability(String hospitalId) {
        String url = getBedsAvailabilityUrl() + URL_COMPONENT_GET + BED_AVAILABILITY;
        ResponseEntity<BedsAvailability> response = restTemplate.postForEntity(url, hospitalId, BedsAvailability.class);
        return response.getBody();
    }

    public String getNearbyHospitals(String coordinates) {
        String url = getNearbyHospitalsUrl() + URL_COMPONENT_GET + NEARBY_HOSPITALS;
        ResponseEntity<String> response = restTemplate.postForEntity(url, coordinates, String.class);
        return response.getBody();
    }
}
