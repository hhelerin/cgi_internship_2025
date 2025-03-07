package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.model.Airport;
import com.example.cgi_internship_2025.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {
    List<Flight> findByFromAirportAndToAirport(Airport fromAirport, Airport toAirport);
}

