package com.example.cgi_internship_2025.service;
import com.example.cgi_internship_2025.model.Seat;
import com.example.cgi_internship_2025.repository.SeatRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class SeatService {

    private SeatRepository seatRepository;

    public List<Seat> getAvailableSeats(Long seatingPlanId) {
        return seatRepository.findAll();
    }


}

