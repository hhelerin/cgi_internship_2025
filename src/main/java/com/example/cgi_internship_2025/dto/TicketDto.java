package com.example.cgi_internship_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDto{
    private Long id;
    private String ticketNumber;
    private String flightNumber;
    private FlightDto flightDto;
    private String seatNumber;
}