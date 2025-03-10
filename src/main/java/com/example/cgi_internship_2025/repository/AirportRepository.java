package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByAirportCode(String airportCode);
    Optional<Airport> findByCity(String city);
    Optional<Airport> findByCountry(String country);
}

