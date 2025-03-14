package com.example.cgi_internship_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long flightId;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int availableSeats;
    private int basePrice;

    public int getCalculatedPrice() {

        long daysUntilDeparture = ChronoUnit.DAYS.between(LocalDate.now(), departureDate);

        // Increase price if departure is soon
        double timeFactor = daysUntilDeparture < 7 ? 1.5 : daysUntilDeparture < 30 ? 1.2 : 1.0;

        // Adjust price based on seat availability
        double availabilityFactor = availableSeats < 10 ? 1.3 : availableSeats < 50 ? 1.1 : 1.0;

        return (int) Math.round(basePrice * timeFactor * availabilityFactor);
    }

}