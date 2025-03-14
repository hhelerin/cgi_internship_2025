package com.example.cgi_internship_2025.controller;

import com.example.cgi_internship_2025.dto.AirportDto;
import com.example.cgi_internship_2025.dto.FlightDto;
import com.example.cgi_internship_2025.service.AirportService;
import com.example.cgi_internship_2025.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/flightland")
public class FlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private AirportService airportService;

    @GetMapping("/search")
    public String searchFlights(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam int passengers,
            Model model) {

        List<FlightDto> flights = flightService.searchFlights(from, to, date, passengers);
        model.addAttribute("flights", flights);
        return "flightlist";
    }

    @GetMapping("/")
    public String showFrontPage(Model model) {
        List<AirportDto> airports = airportService.getAllAirports();
        model.addAttribute("airports", airports);
        return "frontpage";
    }

    @GetMapping("/upcoming")
    public String getUpcoming(Model model) {

        List<FlightDto> flights = flightService.getAllUpcoming();
        model.addAttribute("flights", flights);
        return "flightlist";
    }
}
