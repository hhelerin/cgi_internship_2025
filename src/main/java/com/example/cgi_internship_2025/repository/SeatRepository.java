package com.example.cgi_internship_2025.repository;
import com.example.cgi_internship_2025.ESeatClass;
import com.example.cgi_internship_2025.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findBySeatClass(ESeatClass seatClass);
}

