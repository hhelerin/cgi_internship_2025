package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.dto.FlightDto;
import com.example.cgi_internship_2025.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;



@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f " +
            "JOIN FlightSchedule fs on fs.id=f.flightSchedule.id " +
            "JOIN  Route r on  r.id=fs.route.id " +
            "JOIN Airport dep on r.fromAirport = dep.id " +
            "JOIN Airport arr on r.toAirport = arr.id " +
            "WHERE dep.airportCode = :from AND arr.airportCode = :to AND f.date = :date")
    List<Flight> findFlightsByAirportAndDate(@Param("from") String from, @Param("to") String to, @Param("date") LocalDate date);



    @Query("SELECT f FROM Flight f WHERE DATE(f.date) = :date")
    List<Flight> findFlightsByDate(@Param("date") LocalDate date);


    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.date > current_date " +
            "ORDER BY f.date, fs.departureTime, r.toAirport.airportCode")
    List<FlightDto> findAllUpcomingFlightsInfo();


}

