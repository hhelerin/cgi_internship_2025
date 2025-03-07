package com.example.cgi_internship_2025.model;
import java.util.UUID;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aircraft_types")
public class AircraftType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Size(max = 128)
    private String name;
    @Size(max = 128)
    private String modelNumber;
    @Size(max = 128)
    private String manufacturer;
    @Size(max = 128)
    private String seatLayoutType;
    @Size(max = 255)
    private String details;
}
