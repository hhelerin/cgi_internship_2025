package com.example.cgi_internship_2025.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

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
    private LocalDate validFrom;
    private LocalDate validUntil;
    @Column(name = "base_price", nullable = false)
    private int basePrice;

    @ManyToOne
    @JoinColumn(name = "aircraft_type", nullable = false)
    private AircraftType aircraftType;
}
