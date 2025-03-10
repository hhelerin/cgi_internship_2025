package com.example.cgi_internship_2025.model;
import java.util.UUID;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flights")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(nullable = false)
    @Size(max = 64)
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "from_airport", nullable = false)
    private Airport fromAirport;

    @ManyToOne
    @JoinColumn(name = "to_airport", nullable = false)
    private Airport toAirport;

    @Min(0)
    private int durationMinutes;

    @ManyToOne
    @JoinColumn(name = "airline", nullable = false)
    private Airline airline;
    @Size(max = 255)
    private String additionalInfo;
}
