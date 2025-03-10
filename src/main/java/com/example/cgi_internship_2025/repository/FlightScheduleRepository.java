package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.model.Route;
import com.example.cgi_internship_2025.model.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long> {
    List<FlightSchedule> findByRoute(Route route);
}

