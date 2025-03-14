package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.dto.AirportDto;
import com.example.cgi_internship_2025.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByAirportCode(String airportCode);
    Optional<Airport> findByCity(String city);
    Optional<Airport> findByCountry(String country);


    @Query("SELECT new com.example.cgi_internship_2025.dto.AirportDto(a.id, a.name, a.airportCode, a.city, a.country) " +
            "FROM Airport a " +
            "ORDER BY a.airportCode")
    List<AirportDto> findAllAirportDtos();
}

