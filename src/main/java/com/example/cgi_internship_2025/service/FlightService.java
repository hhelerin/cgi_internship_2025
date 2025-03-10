package com.example.cgi_internship_2025.service;

import com.example.cgi_internship_2025.dto.FlightDto;
import com.example.cgi_internship_2025.model.Flight;
import com.example.cgi_internship_2025.model.Airport;
import com.example.cgi_internship_2025.model.FlightSchedule;
import com.example.cgi_internship_2025.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

/*    public List<Flight> searchFlights(UUID fromAirportId, UUID toAirportId) {
        Airport fromAirport = new Airport();
        fromAirport.setId(fromAirportId);
        Airport toAirport = new Airport();
        toAirport.setId(toAirportId);
        return flightRepository.findByFromAirportAndToAirport(fromAirport, toAirport);
    }*/

    public List<Flight> getFlightDetails(FlightSchedule flightSchedule) {
        return flightRepository.findByFlightSchedule(flightSchedule);
    }
    public List<FlightDto> findFlightsByCriteria(String from, String to, LocalDate date) {
        return new ArrayList<>();
    }

}


