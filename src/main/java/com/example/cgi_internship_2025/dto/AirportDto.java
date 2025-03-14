package com.example.cgi_internship_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportDto {
    private Long airportId;
    private String name;
    private String airportCode;
    private String city;
    private String country;

}
