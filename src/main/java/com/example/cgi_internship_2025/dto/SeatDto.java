package com.example.cgi_internship_2025.dto;

import com.example.cgi_internship_2025.EReclineType;
import com.example.cgi_internship_2025.ESeatClass;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeatDto {
    private Long seatingPlanId;
    private Long flightId;
    private int seatRowNumber;
    private char seatColumnChar;
    private boolean isWindow;
    private boolean isAisle;
    private ESeatClass seatClass;
    private EReclineType reclineType;
    private boolean emergencyExit;
    private boolean tv;
    private boolean powerPort;
    private boolean babyBassinet;
    private boolean available;
    private boolean selected = false;
}

