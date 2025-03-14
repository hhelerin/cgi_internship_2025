package com.example.cgi_internship_2025.repository;

import com.example.cgi_internship_2025.ESeatClass;
import com.example.cgi_internship_2025.dto.SeatDto;
import com.example.cgi_internship_2025.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findBySeatClass(ESeatClass seatClass);

/*
    @Query("SELECT new com.example.cgi_internship_2025.dto.SeatDto(sm.id,  f.id, sm.rowNumber, sm.seatColumnChar, " +
            "s.window, s.aisle, s.seatClass, s.reclineType, s.emergencyExit, s.tv, s.powerPort, s.babyBassinet, " +
            "(CASE WHEN t.id IS NULL THEN true ELSE false END)) " +
            "FROM Flight f" +
            " LEFT OUTER JOIN Ticket t " +
            "JOIN SeatMapping sm " +
            "JOIN Seat s" +
            " WHERE f.id = :flightId")
    List<SeatDto> getAllSeatDtoByFlight (@Param("flightId") Long flightId);

*/

    @Query("SELECT new com.example.cgi_internship_2025.dto.SeatDto(sm.id, f.id, sm.rowNumber, sm.seatColumnChar, " +
            "s.window, s.aisle, s.seatClass, s.reclineType, s.emergencyExit, s.tv, s.powerPort, s.babyBassinet, " +
            "(CASE WHEN t.id IS NULL THEN true ELSE false END)) " +
            "FROM Flight f " +
            "JOIN f.flightSchedule fs " +
            "JOIN fs.aircraftType at " +
            "JOIN at.seatMappings sm " +
            "JOIN sm.seat s " +
            "LEFT JOIN Ticket t ON t.seatMapping.id = sm.id " +
            "WHERE f.id = :flightId")
    List<SeatDto> getAllSeatDtoByFlight(@Param("flightId") Long flightId);

}

