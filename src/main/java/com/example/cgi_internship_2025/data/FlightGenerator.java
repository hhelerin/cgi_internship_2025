package com.example.cgi_internship_2025.data;

import com.example.cgi_internship_2025.model.Flight;
import com.example.cgi_internship_2025.model.FlightSchedule;
import com.example.cgi_internship_2025.repository.FlightRepository;
import com.example.cgi_internship_2025.repository.FlightScheduleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class FlightGenerator implements CommandLineRunner {

    private FlightScheduleRepository flightScheduleRepository;
    private FlightRepository flightRepository;

    @Override
    public void run(String... args) {
        generateFutureFlights();
    }

    private void generateFutureFlights() {
        List<FlightSchedule> schedules = flightScheduleRepository.findAll();
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusMonths(4);

        for (FlightSchedule schedule : schedules) {
            LocalDate date = today;
            while (!date.isAfter(endDate)) {
                if (matchesSchedule(schedule, date)) {
                    Flight flight = new Flight();
                    flight.setDate(date);
                    flight.setAmountOfSeats(schedule.getAircraftType().getSeatingPlans().size());
                    flight.setAvailableSeats(flight.getAmountOfSeats());
                    flightRepository.save(flight);
                }
                date = date.plusDays(1);
            }
        }
    }

    private boolean matchesSchedule(FlightSchedule schedule, LocalDate date) {
        String weekday = date.getDayOfWeek().toString().substring(0, 3).toUpperCase(); // "MON", "TUE", etc.
        return schedule.getWeekday().contains(weekday);
    }
}

