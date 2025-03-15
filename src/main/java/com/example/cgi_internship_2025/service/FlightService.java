package com.example.cgi_internship_2025.service;

import com.example.cgi_internship_2025.data.FlightGenerator;
import com.example.cgi_internship_2025.dto.FlightDto;
import com.example.cgi_internship_2025.dto.FlightWithSeatsDto;
import com.example.cgi_internship_2025.dto.SeatDto;
import com.example.cgi_internship_2025.repository.FlightRepository;
import com.example.cgi_internship_2025.repository.SeatRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private FlightGenerator flightGenerator;

    public List<FlightDto> getAllUpcoming() {
        return flightRepository.findAllUpcomingFlightsInfo();
    }

    public List<FlightDto> searchFlights(String from, String to, LocalDate date, int passengers) {
        return flightRepository.findFlightsByAirportAndDate(from, to, date, passengers);
    }

    public List<FlightDto> searchFlightsByDate(LocalDate date, int passengers) {
        return flightRepository.findByDate(date, passengers);
    }

    public List<FlightDto> searchFlightsFrom(String from, LocalDate date,int passengers) {
        return flightRepository.findByFromAndDate(from, date, passengers);
    }

    public List<FlightDto> searchFlightsTo(String to, LocalDate date, int passengers) {
        return flightRepository.findByToAndDate(to, date, passengers);
    }

    public FlightWithSeatsDto getFlightWitSeatsDtoById(Long id) {
        FlightWithSeatsDto flightWithSeatsDto = flightRepository.getFlightWithSeatsDtoById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight with ID " + id + " not found."));
        List<SeatDto> seatDtos = seatRepository.getAllSeatDtoByFlight(id);
        Map<Integer, List<SeatDto>> groupedSeats = seatDtos.stream()
                .sorted(Comparator.comparingInt(SeatDto::getSeatRowNumber)
                        .thenComparing(SeatDto::getSeatColumnChar))
                .collect(Collectors.groupingBy(SeatDto::getSeatRowNumber));

        List<List<SeatDto>> seatList = new ArrayList<>(groupedSeats.values());
        flightWithSeatsDto.setSeatList(seatList);

        return flightWithSeatsDto;
    }

    public void generateFlightsForDate(LocalDate date){
        flightGenerator.generateFutureFlights(date, date);
    }

}


