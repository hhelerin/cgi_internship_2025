package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.dto.FlightDto;
import com.example.cgi_internship_2025.dto.FlightWithSeatsDto;
import com.example.cgi_internship_2025.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, r.fromAirport.name, r.toAirport.name, " +
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
            "r.fromAirport.airportCode, r.toAirport.airportCode, r.fromAirport.name, r.toAirport.name, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.date  = :date " +
            "ORDER BY f.date, fs.departureTime, r.toAirport.airportCode")
    List<FlightDto> findFlightsByDate(@Param("date") LocalDate date,
                                      @Param("passengers") int passengers);


    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, r.fromAirport.name, r.toAirport.name, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.date > current_date " +
            "ORDER BY f.date, fs.departureTime, r.toAirport.airportCode")
    List<FlightDto> findAllUpcomingFlightsInfo();


    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightWithSeatsDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, " +
            "f.date, fs.departureTime, fs.arrivalTime) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.id = :id ")
    Optional<FlightWithSeatsDto> getFlightWithSeatsDtoById(@Param("id") Long id);


    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, r.fromAirport.name, r.toAirport.name, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.date  = :date "+
            "ORDER BY f.date, fs.departureTime, r.fromAirport.airportCode")
    List<FlightDto> findByDate(@Param("date") LocalDate date,
                               @Param("passengers") int passengers);


    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, r.fromAirport.name, r.toAirport.name, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.date  = :date " +
            "AND r.fromAirport.airportCode  = :from " +
            "ORDER BY r.toAirport.airportCode, fs.basePrice")
    List<FlightDto> findByFromAndDate(@Param("from") String from,
                                      @Param("date") LocalDate date,
                                      @Param("passengers") int passengers);


    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, r.fromAirport.name, r.toAirport.name, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE f.date  = :date " +
            "AND r.toAirport.airportCode  = :to " +
            "ORDER BY f.date, fs.departureTime, r.fromAirport.airportCode")
    List<FlightDto> findByToAndDate(@Param("to") String to,
                                    @Param("date") LocalDate date,
                                    @Param("passengers") int passengers);

    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, r.fromAirport.name, r.toAirport.name, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) "
            + "FROM Flight f "
            + "JOIN f.flightSchedule.route r "
            + "JOIN f.flightSchedule fs " +
            "WHERE r.id  = :routeId " +
            "ORDER BY f.date, fs.departureTime")
    List<FlightDto> findByRoute(@Param("routeId") Long routeId, @Param("passengers") int passengers);


    @Query("SELECT new com.example.cgi_internship_2025.dto.FlightDto(f.id, r.flightNumber, " +
            "r.fromAirport.airportCode, r.toAirport.airportCode, r.fromAirport.name, r.toAirport.name, " +
            "f.date, f.date, fs.departureTime, fs.arrivalTime, f.availableSeats, fs.basePrice) " +
            "FROM Flight f " +
            "JOIN f.flightSchedule.route r " +
            "JOIN f.flightSchedule fs " +
            "WHERE (:from IS NULL OR r.fromAirport.airportCode = :from) " +
            "AND (:to IS NULL OR r.toAirport.airportCode = :to) " +
            "AND (:date IS NULL OR f.date = :date) " +
            "AND (:departureTime IS NULL OR fs.departureTime = :departureTime) " +
            "AND (:maxPrice IS NULL OR fs.basePrice <= :maxPrice)")
    List<FlightDto> findFlightsWithFilters(@Param("from") String from,
                                           @Param("to") String to,
                                           @Param("date") LocalDate date,
                                           @Param("departureTime") LocalTime departureTime,
                                           @Param("maxPrice") Double maxPrice);
    //TODO: Fix filtering by price where comparing should be by calculatedPrice, not by basePrice

}