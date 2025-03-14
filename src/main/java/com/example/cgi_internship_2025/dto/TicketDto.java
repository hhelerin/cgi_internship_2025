package com.example.cgi_internship_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto{
    private Long ticketId;
    private String flightNumber;
    private Long flightId;
    private String seatNumber;
    private String ticketNumber = flightNumber + "-" + seatNumber;;
}