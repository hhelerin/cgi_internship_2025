package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.model.Airport;
import com.example.cgi_internship_2025.model.Flight;
import com.example.cgi_internship_2025.model.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
/*
    List<Flight> findByFromAirportAndToAirport(Airport fromAirport, Airport toAirport);

    @Query("SELECT f FROM Flight f " +
            "JOIN FlightSchedule fs on fs.id=f.flightSchedule.id " +
            "JOIN  Route r on  r.id=fs.route.id " +
            "JOIN Airport dep on r.fromAirport = dep.id " +
            "JOIN Airport arr on r.toAirport = arr.id " +
            "WHERE dep.IATA_code = :from AND arr.IATA_code = :to AND f.flightSchedule.startDate = :date")
    List<Flight> findFlightsByAirportAndDate(@Param("from") String from, @Param("to") String to, @Param("date") LocalDate date);
*/
List<Flight> findByFlightSchedule(FlightSchedule flightSchedule);

    @Query("SELECT f FROM Flight f WHERE DATE(f.date) = :date")
    List<Flight> findFlightsByDate(@Param("date") LocalDate date);

    List<Flight> findByDateAfter(LocalDate today);


}

