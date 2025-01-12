package com.example.airtravelwebapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.airtravelwebapp.model.Flight;
import com.example.airtravelwebapp.model.FlightSearchResponse;
import com.example.airtravelwebapp.repository.FlightRepository;

/**
 * Service class for fetching and saving live flight data.
 */
@Service
public class LiveDataService {

    private static final Logger logger = LoggerFactory.getLogger(LiveDataService.class); // Logger for logging messages

    @Autowired
    private FlightRepository flightRepository; // Repository for accessing flight data

    private final RestTemplate restTemplate = new RestTemplate(); // RestTemplate for making HTTP requests

    private static final String API_URL = "http://api.aviationstack.com/v1/flights"; // API URL for fetching flight data
    private static final String ACCESS_KEY = "e55cd9938b6bcf1b79ff775182603c81"; // Replace with your actual access key

    /**
     * Fetches live flight data from the API and saves it to the database.
     * This method is scheduled to run every hour.
     */
    @Scheduled(fixedRate = 3600000) // Run every hour
    public void fetchAndSaveLiveData() {
        try {
            // Construct the URL with the access key
            String url = API_URL + "?access_key=" + ACCESS_KEY;
            logger.info("Fetching live data from URL: {}", url);
            
            // Make the HTTP GET request and parse the response
            FlightSearchResponse response = restTemplate.getForObject(url, FlightSearchResponse.class);
            
            // Check if the response contains flight data
            if (response != null && response.getFlights() != null && !response.getFlights().isEmpty()) {
                logger.info("Fetched {} flights", response.getFlights().size());
                int count = 0;
                
                // Save each flight to the repository, up to a maximum of 12 flights
                for (Flight flight : response.getFlights()) {
                    if (count >= 12) {
                        break;
                    }
                    logger.info("Saving flight: {}", flight);
                    flightRepository.save(flight);
                    count++;
                }
                logger.info("Saved {} flights", count);
            } else {
                // Log a warning if no flights were found in the response
                logger.warn("No flights found in the response");
            }
        } catch (Exception e) {
            // Log any errors that occur during the fetch and save process
            logger.error("Error fetching live data", e);
        }
    }
}