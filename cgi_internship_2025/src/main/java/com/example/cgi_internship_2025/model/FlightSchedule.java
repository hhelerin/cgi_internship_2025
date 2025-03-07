package com.example.cgi_internship_2025.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flight_schedule")
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @NotNull
    @Size(min = 7, max = 7)
    @Column(nullable = false)
    private String weekday;
    @NotNull
    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;
    @NotNull
    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;
    private LocalDate startDate;
    private LocalDate endDate;
    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;

    @ManyToOne
    @JoinColumn(name = "aircraft_type", nullable = false)
    private AircraftType aircraftType;
}
