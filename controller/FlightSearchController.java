package com.example.airtravelwebapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airtravelwebapp.model.Flight;
import com.example.airtravelwebapp.model.FlightSearchCriteria;
import com.example.airtravelwebapp.service.FlightService;


/**
 * REST controller for handling flight search requests.
 */
@RestController
@RequestMapping("/api/flightsearch")
public class FlightSearchController {

    private static final Logger logger = LoggerFactory.getLogger(FlightSearchController.class);

    private final FlightService flightService;

    /**
     * Constructor for FlightSearchController.
     * 
     * @param flightService the service to handle flight operations
     */
    @Autowired
    public FlightSearchController(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Endpoint to search for flights based on criteria.
     * 
     * @param searchCriteria the search criteria
     * @return a ResponseEntity containing a list of matching flights
     */
    @PostMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(@RequestBody FlightSearchCriteria searchCriteria) {
        logger.info("Searching for flights with criteria: {}", searchCriteria);
        List<Flight> flights = flightService.searchFlights(searchCriteria);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}