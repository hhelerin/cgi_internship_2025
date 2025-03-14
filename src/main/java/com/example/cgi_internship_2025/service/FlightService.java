package com.example.cgi_internship_2025.service;

import com.example.cgi_internship_2025.dto.FlightDto;
import com.example.cgi_internship_2025.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<FlightDto> getAllUpcoming() {
        return flightRepository.findAllUpcomingFlightsInfo();
    }

    public List<FlightDto> searchFlights(String from, String to, LocalDate date, int passengers) {
        return flightRepository.findFlightsByAirportAndDate(from, to, date, passengers);
    }


    //TODO: get list of flightWithSeatsDto. In flightID, out flightWithSeatsDto. Outer join with tickets.



}


