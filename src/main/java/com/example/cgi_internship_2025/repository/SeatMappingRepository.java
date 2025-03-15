package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.model.AircraftType;
import com.example.cgi_internship_2025.model.SeatMapping;
import com.example.cgi_internship_2025.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatMappingRepository extends JpaRepository<SeatMapping, Long> {
    List<SeatMapping> findByAircraft(AircraftType aircraft);

    default void addTicket(SeatMapping seatMapping, Ticket ticket){

        seatMapping.getTickets().add(ticket);
    }
}

