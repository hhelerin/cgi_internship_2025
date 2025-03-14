package com.example.cgi_internship_2025.service;

import com.example.cgi_internship_2025.dto.RouteDto;
import com.example.cgi_internship_2025.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<RouteDto> getAllRouteDtos() {
        return routeRepository.getAllRouteDtos();
    }
}
