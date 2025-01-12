Air Travel Web Application
Overview
The Air Travel Web Application is a Spring Boot-based web application designed to manage flight bookings, search for flights, and handle user authentication. The application provides RESTful APIs for various operations related to flights, bookings, and users.

Features
Flight Search: Search for available flights based on criteria such as origin, destination, and travel date.
Flight Booking: Book flights by creating new bookings and saving them to the repository.
User Authentication: Register and authenticate users using XML-based user data storage.
Live Flight Data: Fetch and store live flight data from the AviationStack API.
RESTful APIs: Expose endpoints for flight search, booking, and user-related operations.

Getting Started
Prerequisites
Java 21
Maven 3.9.9
MySQL Database

Installation
Clone the repository:
git clone https://github.com/your-repo/airtravelwebapp.git
cd airtravelwebapp

Configure the database: Update the application.properties file with your MySQL database credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/airtravelwebapp
spring.datasource.username=root
spring.datasource.password=password

Build the project:
./mvnw clean install

Run the application:
./mvnw spring-boot:run

Running Tests
To run the tests, use the following command:
./mvnw test

Usage
API Endpoints
User Endpoints
Register User: POST /api/users/register

Parameters: username, password
Response: Registration status message
Authenticate User: POST /api/users/authenticate

Parameters: username, password
Response: Authentication status message
Flight Endpoints
Search Flights: GET /api/flights/search

Parameters: origin, destination, travelDate
Response: List of matching flights
Book Flight: POST /api/bookings

Parameters: userId, flightId, bookingDate
Response: Booking confirmation
Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

License
This project is licensed under the Apache License 2.0. See the LICENSE file for details.

Acknowledgements
Spring Boot
AviationStack API
MySQL
Maven
Contact
For any inquiries or support, please contact your-email@example.com.

This README provides an overview of the Air Travel Web Application, including its features, project structure, installation steps, usage, and contribution guidelines.