package com.example.cgi_internship_2025.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flight_schedule")
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Route route;

    @NotNull
    @Size(min = 3, max = 3)
    @Column(nullable = false)
    private String weekday;
    @NotNull
    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;
    @NotNull
    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;
    private LocalDate validFrom;
    private LocalDate validUntil;
    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;

    @ManyToOne
    @JoinColumn(name = "aircraft_type", nullable = false)
    private AircraftType aircraftType;
}
