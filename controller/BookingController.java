package com.example.airtravelwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.airtravelwebapp.model.Booking;
import com.example.airtravelwebapp.service.BookingService;

/**
 * REST controller for handling booking-related requests.
 */
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    // Service for handling booking-related operations
    private final BookingService bookingService;

    /**
     * Constructor for BookingController.
     * 
     * @param bookingService the service to handle booking operations
     */
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Endpoint to book a flight.
     * 
     * @param userId the ID of the user making the booking
     * @param flightId the ID of the flight to be booked
     * @param bookingDate the date of the booking
     * @return the created Booking object
     */
    @PostMapping
    public Booking bookFlight(@RequestParam Long userId, @RequestParam Long flightId, @RequestParam String bookingDate) {
        return bookingService.bookFlight(userId, flightId, bookingDate);
    }

    /**
     * Endpoint to get all bookings.
     * 
     * @return a list of all bookings
     */
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    /**
     * Endpoint to get a booking by its ID.
     * 
     * @param id the ID of the booking
     * @return the Booking object with the specified ID
     */
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    /**
     * Endpoint to update an existing booking.
     * 
     * @param id the ID of the booking to be updated
     * @param booking the Booking object with updated details
     * @return the updated Booking object
     */
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        Booking booking = bookingService.updateBooking(id, updatedBooking);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    /**
     * Endpoint to delete a booking by its ID.
     * 
     * @param id the ID of the booking to be deleted
     */
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}