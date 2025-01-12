package com.example.airtravelwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airtravelwebapp.model.Booking;

/**
 * Repository interface for Booking entities.
 * Extends JpaRepository to provide CRUD operations and more.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    /**
     * Finds bookings by user ID.
     * @param userId the ID of the user
     * @return a list of bookings for the specified user
     */
    List<Booking> findByUserId(Long userId);

    /**
     * Finds bookings by flight ID.
     * @param flightId the ID of the flight
     * @return a list of bookings for the specified flight
     */
    List<Booking> findByFlightId(Long flightId);

    /**
     * Finds bookings by user ID and flight ID.
     * @param userId the ID of the user
     * @param flightId the ID of the flight
     * @return a list of bookings for the specified user and flight
     */
    List<Booking> findByUserIdAndFlightId(Long userId, Long flightId);
}