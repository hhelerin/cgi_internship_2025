package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
/*    @Query("SELECT new com.example.cgi_internship_2025.dto.TicketDto(t.id,  r.flightNumber, f.id, CONCAT(s.rowNumber, s.seatInRow), CONCAT(r.flightNumber, s.rowNumber, s.seatInRow) ) " +
            "FROM Ticket t " +
            "JOIN t.flight f " +
            "JOIN t.seatMapping s " +
            "JOIN f.flightSchedule fs " +
            "JOIN fs.route r " +
            "WHERE t.id = :ticketId")
    TicketDto findTicketDtoById(@Param("ticketId") Long ticketId);*/
}


