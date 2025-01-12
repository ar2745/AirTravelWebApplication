package com.example.airtravelwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.airtravelwebapp.repository.BookingRepository;
import com.example.airtravelwebapp.repository.FlightRepository;
import com.example.airtravelwebapp.service.LiveDataService;

@Component
public class DatabasePopulator implements CommandLineRunner {

    @Autowired
    private LiveDataService liveDataService;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception {
        // Clear the repository
        // bookingRepository.deleteAll();
        // flightRepository.deleteAll();
        liveDataService.fetchAndSaveLiveData();
    }
}
