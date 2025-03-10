package com.example.cgi_internship_2025.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seating_plans")
public class SeatingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private AircraftType aircraft;

    @NotNull
    @Column(nullable = false)
    private int rowNumber;
    @NotNull
    @Column(nullable = false)
    private char seatInRow;

    private String additionalInfo;
}
