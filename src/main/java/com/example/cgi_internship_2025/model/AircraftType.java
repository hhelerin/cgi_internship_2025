package com.example.cgi_internship_2025.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aircraft_types")
public class AircraftType {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @OneToMany(mappedBy = "aircraft")
    private List<SeatMapping> seatMappings = new ArrayList<>();
}
