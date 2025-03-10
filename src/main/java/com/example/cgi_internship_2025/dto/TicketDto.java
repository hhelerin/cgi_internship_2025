package com.example.cgi_internship_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDto{
    private UUID id;
    private String number;
    private UUID flightDetailsId;
    private UUID seatingPlanId;

}