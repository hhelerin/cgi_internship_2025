package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.dto.FlightDto;
import com.example.cgi_internship_2025.dto.FlightWithSeatsDto;
import com.example.cgi_internship_2025.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE r.toAirport.airportCode  LIKE :to " +
            "AND r.fromAirport.airportCode LIKE  :from " +
            "AND f.date = :date " +
            "AND f.availableSeats >= :passengers " +
            "ORDER BY f.date, fs.departureTime, r.toAirport.airportCode")
    List<FlightDto> findFlightsByAirportAndDate(@Param("from") String from,
                                                @Param("to") String to,
                                                @Param("date") LocalDate date,
                                                @Param("passengers") int passengers);



    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.date  = :date " +
            "ORDER BY f.date, fs.departureTime, r.toAirport.airportCode")
    List<FlightDto> findFlightsByDate(@Param("date") LocalDate date);


    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.date > current_date " +
            "ORDER BY f.date, fs.departureTime, r.toAirport.airportCode")
    List<FlightDto> findAllUpcomingFlightsInfo();


    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.date  = :search "+
            "ORDER BY f.date, fs.departureTime, r.toAirport.airportCode")
    List<FlightDto> findFlightsBySearchString(@Param("search") String search);

    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightWithSeatsDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, " +
            "f.date, fs.departureTime, fs.arrivalTime) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.id = :id ")
    Optional<FlightWithSeatsDto> getFlightWithSeatsDtoById(@Param("id") Long id);


}

