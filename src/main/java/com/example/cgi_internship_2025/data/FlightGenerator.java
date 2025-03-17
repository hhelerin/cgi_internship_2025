package com.example.cgi_internship_2025.data;

import com.example.cgi_internship_2025.model.Flight;
import com.example.cgi_internship_2025.model.FlightSchedule;
import com.example.cgi_internship_2025.model.SeatMapping;
import com.example.cgi_internship_2025.model.Ticket;
import com.example.cgi_internship_2025.repository.FlightRepository;
import com.example.cgi_internship_2025.repository.FlightScheduleRepository;
import com.example.cgi_internship_2025.repository.SeatMappingRepository;
import com.example.cgi_internship_2025.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class FlightGenerator{

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightScheduleRepository flightScheduleRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    SeatMappingRepository seatMappingRepository;


    public void generateFutureFlights(LocalDate start, LocalDate end) {
        List<FlightSchedule> schedules = flightScheduleRepository.findAll();

        for (FlightSchedule schedule : schedules) {
            schedule = flightScheduleRepository.findWithAircraftAndSeats(schedule.getId());
            List<SeatMapping> seatMappings = seatMappingRepository.findByAircraft(schedule.getAircraftType());

            LocalDate date = start;
            while (!date.isAfter(end)) {
                if (matchesSchedule(schedule, date)) {
                    Flight flight = new Flight(null, date, 0, 0, new ArrayList<>(), schedule, null);
                    flight.setAmountOfSeats(seatMappings.size());
                    List<Ticket> tickets = generateRandomTickets(flight, seatMappings);
                    flight.setAvailableSeats(flight.getAmountOfSeats()-tickets.size());
                    flightRepository.save(flight);
                    ticketRepository.saveAll(tickets);
                }
                date = date.plusDays(1);
            }
        }
    }

    private List<Ticket> generateRandomTickets(Flight flight, List<SeatMapping> seatMappings) {
        Random random = new Random();
        int randomAmount = random.nextInt(2,flight.getAmountOfSeats()/2);
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < randomAmount; i++) {
            Ticket ticket = new Ticket(null, flight, seatMappings.get(i));
            tickets.add(ticket);
            seatMappingRepository.addTicket(seatMappings.get(i), ticket);
            i = i + random.nextInt(1,4);
        }
        return tickets;
    }

    private boolean matchesSchedule(FlightSchedule schedule, LocalDate date) {
    int weekday = date.getDayOfWeek().getValue();  // 1 = Monday, 7 = Sunday
    String scheduleWeekdays = schedule.getWeekday();  // "12345--" or "1-3-5--"

    // Check if the character at the weekday position is not a dash
    return scheduleWeekdays.charAt(weekday - 1) != '-';
}
}


