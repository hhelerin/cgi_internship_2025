package com.example.cgi_internship_2025.controller;

import com.example.cgi_internship_2025.dto.FlightDto;
import com.example.cgi_internship_2025.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;


    @GetMapping("/search")
    public ResponseEntity<List<FlightDto>> searchFlights(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam LocalDate date) {
        List<FlightDto> flights = flightService.findFlightsByCriteria(from, to, date);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/upcoming")
    public List<FlightDto> getUpcomingFlights() {
        return flightService.getAllUpcoming();
    }

}
