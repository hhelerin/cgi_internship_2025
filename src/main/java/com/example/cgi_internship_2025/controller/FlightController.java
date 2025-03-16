package com.example.cgi_internship_2025.controller;

import com.example.cgi_internship_2025.dto.AirportDto;
import com.example.cgi_internship_2025.dto.FlightDto;
import com.example.cgi_internship_2025.dto.FlightWithSeatsDto;
import com.example.cgi_internship_2025.dto.RouteDto;
import com.example.cgi_internship_2025.service.AirportService;
import com.example.cgi_internship_2025.service.FlightService;
import com.example.cgi_internship_2025.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/flightland")
public class FlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private AirportService airportService;
    @Autowired
    private RouteService routeService;

    @GetMapping("/search")
    public String searchFlights(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam int passengers,
            Model model) {
        List<FlightDto> flights;
        if (from == null && to == null) {
            flights = flightService.searchFlightsByDate(date, passengers);
            if(flights.isEmpty()){
                flightService.generateFlightsForDate(date);
            }
            flights = flightService.searchFlightsByDate(date, passengers);
        } else if (from != null && to == null) {
            flights = flightService.searchFlightsFrom(from, date, passengers);
        } else if (from == null) {
            flights = flightService.searchFlightsTo(to, date, passengers);
        } else {
            flights = flightService.searchFlights(from, to, date, passengers);
        }
        return getFlightlistAttributes(model, flights);
    }

    private String getFlightlistAttributes(Model model, List<FlightDto> flights) {
        Set<String> departureAirports = flights.stream()
                .map(FlightDto::getDepartureAirport)
                .collect(Collectors.toSet());

        Set<String> arrivalAirports = flights.stream()
                .map(FlightDto::getArrivalAirport)
                .collect(Collectors.toSet());

        model.addAttribute("flights", flights);
        model.addAttribute("departureAirports", departureAirports);
        model.addAttribute("arrivalAirports", arrivalAirports);
        return "flightlist";
    }

    @GetMapping({"", "/"})
    public String showFrontPage(Model model) {
        List<AirportDto> airports = airportService.getAllAirports();
        model.addAttribute("airports", airports);
        return "frontpage";
    }

    @GetMapping("/upcoming")
    public String getUpcoming(Model model) {
        List<FlightDto> flights = flightService.getAllUpcoming();
        return getFlightlistAttributes(model, flights);
    }
    @GetMapping("/route/{routeId}")
    public String getFlightsByRoute(@PathVariable Long routeId, Model model) {
        List<FlightDto> flights = flightService.searchFlightsByRoute(routeId, 1);
        return getFlightlistAttributes(model, flights);
    }

    @GetMapping("/routes")
    public String getRoutes(Model model) {
        List<RouteDto> routes = routeService.getAllRouteDtos();
        model.addAttribute("routes", routes);
        return "routes";
    }

    @GetMapping("/filter")
    public String filterFlights(
            @RequestParam(required = false) String departureAirport,
            @RequestParam(required = false) String arrivalAirport,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String departureTime,
            @RequestParam(required = false) Double maxPrice,
            Model model) {

        LocalDate parsedDate = (date != null && !date.isEmpty()) ? LocalDate.parse(date) : null;

        LocalTime parsedTime = (departureTime != null && !departureTime.isEmpty()) ? LocalTime.parse(departureTime) : null;

        List<FlightDto> flights = flightService.filterFlights(departureAirport, arrivalAirport, parsedDate, parsedTime, maxPrice);
        return getFlightlistAttributes(model, flights);
    }


    @GetMapping("/{id}")
    public String getFlightDetails(@PathVariable Long id, @RequestParam int passengers, Model model) {
        FlightWithSeatsDto flight = flightService.getFlightWitSeatsDtoById(id);
        model.addAttribute("flight", flight);
        model.addAttribute("passengers", passengers);
        return "flightdetails";
    }

    @GetMapping("/{flightId}/details")
    public ResponseEntity<FlightWithSeatsDto> getFlightDetails(@PathVariable Long flightId) {
        FlightWithSeatsDto flightDetails = flightService.getFlightWitSeatsDtoById(flightId);
        return ResponseEntity.ok(flightDetails);
    }
}
