package com.example.airtravelwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airtravelwebapp.model.Booking;
import com.example.airtravelwebapp.model.Flight;
import com.example.airtravelwebapp.repository.BookingRepository;
import com.example.airtravelwebapp.repository.FlightRepository;

/**
 * Service class for handling booking-related operations.
 */
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository; // Repository for Booking entities

    @Autowired
    private FlightRepository flightRepository; // Repository for Flight entities

    /**
     * Books a flight by creating a new Booking entity and saving it to the repository.
     * 
     * @param userId the ID of the user making the booking
     * @param flightId the ID of the flight to be booked
     * @param bookingDate the date of the booking
     * @return the created Booking object
     */
    public Booking bookFlight(Long userId, Long flightId, String bookingDate) {
        // Fetch the flight by its ID
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid flight ID: " + flightId));

        // Create a new Booking entity
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setFlight(flight); // Set the Flight object
        booking.setBookingDate(bookingDate);

        // Save the Booking entity to the repository
        return bookingRepository.save(booking);
    }

    /**
     * Retrieves all bookings from the repository.
     * 
     * @return a list of all bookings
     */
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    /**
     * Retrieves a booking by its ID from the repository.
     * 
     * @param id the ID of the booking
     * @return the Booking object with the specified ID, or null if not found
     */
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing booking in the repository.
     * 
     * @param id the ID of the booking to be updated
     * @param updatedBooking the Booking object with updated details
     * @return the updated Booking object, or null if the booking with the specified ID does not exist
     */
    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setUserId(updatedBooking.getUserId());
            booking.setFlight(updatedBooking.getFlight());
            booking.setBookingDate(updatedBooking.getBookingDate());
            return bookingRepository.save(booking);
        }).orElse(null);
    }

    /**
     * Deletes a booking by its ID from the repository.
     * 
     * @param id the ID of the booking to be deleted
     */
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}