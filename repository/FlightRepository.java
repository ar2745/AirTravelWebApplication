package com.example.airtravelwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airtravelwebapp.model.Flight;
import com.example.airtravelwebapp.model.FlightSearchCriteria;

/**
 * Repository interface for accessing Flight data from the database.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    
    /**
     * Finds flights by origin, destination, and departure time.
     * @param origin the origin airport code
     * @param destination the destination airport code
     * @param departureTime the departure time
     * @return a list of flights matching the criteria
     */
    List<Flight> findByOriginAndDestinationAndDepartureTime(String origin, String destination, String departureTime);

    /**
     * Finds flights by origin and destination.
     * @param origin the origin airport code
     * @param destination the destination airport code
     * @return a list of flights matching the criteria
     */
    List<Flight> findByOriginAndDestination(String origin, String destination);

    /**
     * Finds flights by price range.
     * @param minPrice the minimum price
     * @param maxPrice the maximum price
     * @return a list of flights within the specified price range
     */
    List<Flight> findByPriceBetween(double minPrice, double maxPrice);

    /**
     * Finds flights by available seats.
     * @param availableSeats the minimum number of available seats
     * @return a list of flights with available seats greater than or equal to the specified number
     */
    List<Flight> findByAvailableSeatsGreaterThanEqual(int availableSeats);

    /**
     * Finds flights based on search criteria.
     * @param searchCriteria the search criteria
     * @return a list of flights matching the search criteria
     */
    default List<Flight> findByCriteria(FlightSearchCriteria searchCriteria) {
        // Implement the search logic here
        // This is a simplified example, you might need to adjust it based on your actual requirements
        if (searchCriteria.getStartLocation() != null && searchCriteria.getEndLocation() != null) {
            return findByOriginAndDestination(searchCriteria.getStartLocation(), searchCriteria.getEndLocation());
        }
        return List.of(); // Return an empty list if criteria are not met
    }
}