package com.example.cgi_internship_2025.service;

import com.example.cgi_internship_2025.dto.AirportDto;
import com.example.cgi_internship_2025.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    public List<AirportDto> getAllAirports() {
        return airportRepository.findAllAirportDtos();
    }

}
