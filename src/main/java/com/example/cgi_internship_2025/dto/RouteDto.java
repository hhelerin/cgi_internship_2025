package com.example.cgi_internship_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {
    private Long routeId;
    private String fromAirportCode;
    private String fromAirportName;
    private String toAirportCode;
    private String toAirportName;
    private String airline;
}
