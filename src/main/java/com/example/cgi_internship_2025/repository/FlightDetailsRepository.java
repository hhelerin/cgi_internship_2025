package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.model.FlightDetails;
import com.example.cgi_internship_2025.model.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, UUID> {
    List<FlightDetails> findByFlightSchedule(FlightSchedule flightSchedule);
}
