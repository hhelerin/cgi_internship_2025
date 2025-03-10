package com.example.cgi_internship_2025.controller;
import com.example.cgi_internship_2025.dto.SeatDto;
import com.example.cgi_internship_2025.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SeatSelectionService {
    private final SeatRepository seatRepository;

    public SeatSelectionService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    /**
     * Suggests a seat based on user preferences.
     *
     * @param window Preferred window seat.
     * @param aisle Preferred aisle seat.
     * @param extraLegroom Preferred extra legroom.
     * @param recline Preferred reclining seat.
     * @return An optional SeatDTO with the best-matching seat.
     *
     * Usage Example:
     * {@code
     * Optional<SeatDTO> seat = seatSelectionService.suggestSeat(true, false, true, true);
     * seat.ifPresent(s -> System.out.println("Suggested Seat: " + s.name()));
     * }
     */
/*    public Optional<SeatDto> suggestSeat(boolean window, boolean aisle, boolean extraLegroom, boolean recline) {
        List<SeatDto> seats = seatRepository.findAll().stream()
                .map(seat -> new SeatDto(seat.getId(), seat.getName(), seat.getSeatType(), seat.getWindow(), seat.getAisle(),
                        seat.getLegroom(), seat.getReclineType(), seat.getEmergencyExit(), seat.getTv(), seat.getBulkhead(),
                        seat.getPowerPort(), seat.getBabyBassinet()))
                .toList();

        return seats.stream()
                .filter(seat -> (!window || seat.window()) &&
                        (!aisle || seat.aisle()) &&
                        (!extraLegroom || seat.legroom()) &&
                        (!recline || seat.recline()))
                .min(Comparator.comparing(SeatDTO::name));
    }*/
}
