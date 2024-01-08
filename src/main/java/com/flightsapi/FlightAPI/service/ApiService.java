package com.flightsapi.FlightAPI.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightsapi.FlightAPI.aviation.response.Airport;
import com.flightsapi.FlightAPI.aviation.response.AviationResponse;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ApiService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String apiKey;

    private final List<Airport> airports = new ArrayList<>();

    //@Value()
    private final String jsonFilePath;

    public ApiService(RestTemplate restTemplate, ObjectMapper objectMapper, @Value("${api.key}") String apiKey, @Value("${jsonFilePath") String jsonFilePath) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.apiKey = apiKey;
        this.jsonFilePath = jsonFilePath;
    }

    public AviationResponse getData() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/v1/flights").queryParam("access_key", apiKey);
        return restTemplate.getForObject(builder.toUriString(), AviationResponse.class);
    }

    private void populateAirportsList() {
        try {
            List<Airport> airportsList = objectMapper.readValue(new File(jsonFilePath), new TypeReference<>() {
            });
            this.airports.addAll(airportsList);
        } catch (IOException e) {
            log.error("Error reading airports from file: {}", jsonFilePath, e);
        }
    }



    @PostConstruct
    void run() {
        AviationResponse data = getData();
        log.info("{}", data);
    }
}
