package com.example.cgi_internship_2025.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seat_mappings")
public class SeatMapping {
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
    @Column(name = "seat_column_char", nullable = false)
    private char seatColumnChar;

    private String additionalInfo;

    @OneToMany(mappedBy = "seatMapping")
    private List<Ticket> tickets = new ArrayList<>();
}
