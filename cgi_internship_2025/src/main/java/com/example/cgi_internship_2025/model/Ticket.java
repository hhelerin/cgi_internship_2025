package com.example.cgi_internship_2025.model;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "flight_details", nullable = false)
    private FlightDetails flightDetails;

    @ManyToOne
    @JoinColumn(name = "seating_plans", nullable = false)
    private SeatingPlan seatingPlan;
}
