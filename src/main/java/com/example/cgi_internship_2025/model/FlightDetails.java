package com.example.cgi_internship_2025.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flight_details")
public class FlightDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate date;

    private int amountOfSeats;
    private int availableSeats;

    @OneToMany(mappedBy = "ticket")
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "flight_schedule_id", nullable = false)
    private FlightSchedule flightSchedule;

    private String additionalInfo;
}
