package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.dto.RouteDto;
import com.example.cgi_internship_2025.model.Airline;
import com.example.cgi_internship_2025.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByAirline(Airline airline);

    @Query("SELECT new com.example.cgi_internship_2025.dto.RouteDto(r.id, a1.airportCode, a1.name, " +
            "a2.airportCode, a2.name, aa.name) " +
            "FROM Route r " +
            "JOIN Airport a1 ON r.fromAirport.id = a1.id " +
            "JOIN Airport a2 ON r.toAirport.id = a2.id " +
            "JOIN Airline aa ON r.airline.id = aa.id " +
            "ORDER BY a1.airportCode")
    List<RouteDto> getAllRouteDtos();
}
