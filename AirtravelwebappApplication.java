package com.example.airtravelwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main class for the Air Travel Web Application.
 * This class bootstraps the Spring Boot application.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.airtravelwebapp.repository")
@ComponentScan(basePackages = "com.example.airtravelwebapp")
public class AirtravelwebappApplication {

    /**
     * Main method to run the Spring Boot application.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AirtravelwebappApplication.class, args);
    }
}