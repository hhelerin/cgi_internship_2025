package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.model.AircraftType;
import com.example.cgi_internship_2025.model.SeatingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SeatingPlanRepository extends JpaRepository<SeatingPlan, UUID> {
    List<SeatingPlan> findByAircraftID(AircraftType aircraft);
}

