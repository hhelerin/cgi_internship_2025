package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
}

