package com.example.cgi_internship_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightWithSeatsDto {
    private Long flightId;
    private String flightNumber;
    private String departureAirportCode;
    private String arrivalAirportCode;
    private LocalDate date;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private List<List<SeatDto>> seatList = new ArrayList<>();

    // Constructor without the list
    public FlightWithSeatsDto(Long flightId, String flightNumber, String departureAirportCode,
                              String arrivalAirportCode, LocalDate date,
                              LocalTime departureTime, LocalTime arrivalTime) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureAirportCode = departureAirportCode;
        this.arrivalAirportCode = arrivalAirportCode;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatList = new ArrayList<>();
    }
}

