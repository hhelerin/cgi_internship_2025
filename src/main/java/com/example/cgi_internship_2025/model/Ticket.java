package com.example.cgi_internship_2025.model;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_details", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "seating_plans", nullable = false)
    private SeatMapping seatMapping;
}
