package com.example.cgi_internship_2025.model;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Size(max = 128)
    private String name;
    @NotNull
    @Column(nullable = false)
    @Size(max = 10)
    private String IATA_code;
    @Size(max = 128)
    private String country;
    @Size(max = 128)
    private String city;
    @Size(max = 255)
    private String address;

    @OneToMany(mappedBy = "toAirport")
    private List<Flight> departingFlights = new ArrayList<>();

    @OneToMany(mappedBy = "fromAirport")
    private List<Flight> arrivingFlights = new ArrayList<>();
}
