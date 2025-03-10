package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.model.Airline;
import com.example.cgi_internship_2025.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByAirline(Airline airline);
}
