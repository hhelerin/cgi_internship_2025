package com.example.cgi_internship_2025.data;

import com.example.cgi_internship_2025.EReclineType;
import com.example.cgi_internship_2025.ESeatClass;
import com.example.cgi_internship_2025.model.*;
import com.example.cgi_internship_2025.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private AirlineRepository airlineRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private AircraftTypeRepository aircraftTypeRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatMappingRepository seatMappingRepository;
    @Autowired
    private FlightScheduleRepository flightScheduleRepository;
    @Autowired
    private FlightGenerator flightGenerator;

    @Override
    public void run(String... args) {
        if (airlineRepository.count() == 0) {
            initializeDatabase();
            flightGenerator.generateFutureFlights(LocalDate.now(), LocalDate.now().plusMonths(4));
        }
    }

    private void initializeDatabase() {
        Airline airline1 = new Airline(null, "Finnair", null, new ArrayList<>());
        Airline airline2 = new Airline(null, "Ryanair", null, new ArrayList<>());
        Airline airline3 = new Airline(null, "Air Baltic Corporation", null, new ArrayList<>());
        Airline airline4 = new Airline(null, "Scandinavian Airlines System", null, new ArrayList<>());
        Airline airline5 = new Airline(null, "Air France", null, new ArrayList<>());

        airlineRepository.saveAll(List.of(airline1, airline2, airline3, airline4, airline5));

        Airport airport1 = new Airport(null, "Lennart Meri Tallinn Airport", "TLL", "Estonia", "Tallinn", null, new ArrayList<>(), new ArrayList<>());
        Airport airport2 = new Airport(null, "Amsterdam Schiphol", "AMS", "Netherlands", "Amsterdam", null, new ArrayList<>(), new ArrayList<>());
        Airport airport3 = new Airport(null, "Stockholm Arlanda", "ARN", "Sweden", "Stockholm", null, new ArrayList<>(), new ArrayList<>());
        Airport airport4 = new Airport(null, "Riga International", "RIX", "Latvia", "Riga", null, new ArrayList<>(), new ArrayList<>());
        Airport airport5 = new Airport(null, "Berlin Brandenburg", "BER", "Germany", "Berlin", null, new ArrayList<>(), new ArrayList<>());
        Airport airport6 = new Airport(null, "London Luton", "LTN", "United Kingdom", "London", null, new ArrayList<>(), new ArrayList<>());
        Airport airport7 = new Airport(null, "London Stansted", "STN", "United Kingdom", "London", null, new ArrayList<>(), new ArrayList<>());
        Airport airport8 = new Airport(null, "Tenerife South", "TFS", "Spain", "Tenerife", null, new ArrayList<>(), new ArrayList<>());
        Airport airport9 = new Airport(null, "Warsaw Chopin", "WAW", "Poland", "Warsaw", null, new ArrayList<>(), new ArrayList<>());
        Airport airport10 = new Airport(null, "Frankfurt Am Main", "FRA", "Germany", "Frankfurt", null, new ArrayList<>(), new ArrayList<>());

        airportRepository.saveAll(List.of(airport1, airport2, airport3, airport4, airport5, airport6, airport7, airport8, airport9, airport10));

        Route route1 = new Route(null, "BT 857", airport1, airport2, 90, airline3, null);
        Route route2 = new Route(null, "BT 318", airport1, airport4, 50, airline3, null);
        Route route3 = new Route(null, "SK 1745", airport1, airport3, 85, airline4, null);
        Route route4 = new Route(null, "AF 1544", airport7, airport2, 100, airline5, null);
        Route route5 = new Route(null, "AY 1025", airport1, airport10, 85, airline1, null);
        Route route6 = new Route(null, "AF 2846", airport4, airport8, 160, airline5, null);
        Route route7 = new Route(null, "FR 5414", airport1, airport6, 120, airline2, null);
        Route route8 = new Route(null, "FR 5028", airport9, airport1, 100, airline2, null);
        Route route9 = new Route(null, "SK 6627", airport3, airport5, 75, airline4, null);

        routeRepository.saveAll(List.of(route1, route2, route3, route4, route5, route6, route7, route8, route9));

        airline1.getRoutes().add(route5);
        airline2.getRoutes().addAll(List.of(route7, route8));
        airline3.getRoutes().addAll(List.of(route1, route2));
        airline4.getRoutes().addAll(List.of(route3, route9));
        airline5.getRoutes().addAll(List.of(route4, route6));

        airport1.getDepartingRoutes().addAll(List.of(route1, route2, route3, route5, route7));
        airport1.getArrivingRoutes().add(route8);
        airport2.getArrivingRoutes().add(route4);
        airport3.getArrivingRoutes().add(route3);
        airport3.getDepartingRoutes().add(route9);
        airport4.getDepartingRoutes().add(route6);
        airport4.getArrivingRoutes().add(route2);
        airport5.getArrivingRoutes().add(route9);
        airport6.getArrivingRoutes().add(route7);
        airport7.getDepartingRoutes().add(route4);
        airport8.getArrivingRoutes().add(route6);
        airport9.getDepartingRoutes().add(route8);

        AircraftType embraer = new AircraftType(null, "Embraer E-190", "ERJ-190", "Manu", "Layout 1", null, new ArrayList<>());
        AircraftType boeing = new AircraftType(null, "Boeing 737-700", "737-700", "Boeing", "Layout 2", null, new ArrayList<>());
        AircraftType mock = new AircraftType(null, "Mocker 53", "53-777", "Mockingbird", "Basic Layout", null, new ArrayList<>());

        aircraftTypeRepository.saveAll(List.of(embraer, boeing, mock));

        Seat businessWindowStandard = new Seat(null, ESeatClass.business, "seat", true, false, EReclineType.standard, false, false, false, false, null);
        Seat businessAisleStandard = new Seat(null, ESeatClass.business, "seat", false, true, EReclineType.standard, false, false, false, false, null);
        Seat businessWindowFancy = new Seat(null, ESeatClass.business, "seat", true, false, EReclineType.flat, false, true, true, false, null);
        Seat businessAisleFancy = new Seat(null, ESeatClass.business, "seat", false, true, EReclineType.flat, false, true, true, false, null);
        Seat economyWindow = new Seat(null, ESeatClass.economy, "seat", true, false,  EReclineType.standard, false, false, false, false, null);
        Seat economyCenter = new Seat(null, ESeatClass.economy, "seat", false, false,  EReclineType.standard, false, false, false, false, null);
        Seat economyAisle = new Seat(null, ESeatClass.economy, "seat", false, true,EReclineType.standard, false, false, false, false, null);
        Seat economyWindowNoRecline = new Seat(null, ESeatClass.economy, "seat", true, false,  EReclineType.none, false, false, false, false, null);
        Seat economyAisleNoRecline = new Seat(null, ESeatClass.economy, "seat", false, true,  EReclineType.none, false, false, false, false, null);
        Seat economyWindowExitRow = new Seat(null, ESeatClass.economy, "seat", true, false,  EReclineType.standard, true, false, false, false, null);
        Seat economyAisleExitRow = new Seat(null, ESeatClass.economy, "seat", false, true,  EReclineType.standard, true, false, false, false, null);
        Seat economyWindowTV = new Seat(null, ESeatClass.economy, "seat", true, false,  EReclineType.standard, true, true, false, false, null);
        Seat economyAisleTV = new Seat(null, ESeatClass.economy, "seat", false, true,  EReclineType.standard, true, true, false, false, null);

        seatRepository.saveAll(List.of(businessWindowStandard, businessAisleStandard, businessWindowFancy, businessAisleFancy,
                economyWindow, economyCenter, economyAisle, economyWindowNoRecline, economyAisleNoRecline,
                economyWindowExitRow, economyAisleExitRow, economyWindowTV, economyAisleTV));


        SeatMapping e1a = new SeatMapping(null, businessWindowStandard, embraer, 1, 'A', null);
        SeatMapping e1c = new SeatMapping(null, businessAisleStandard, embraer, 1, 'C', null);
        SeatMapping e1d = new SeatMapping(null, businessAisleStandard, embraer, 1, 'D', null);
        SeatMapping e1f = new SeatMapping(null, businessAisleFancy, embraer, 1, 'F', null);
        SeatMapping e2a = new SeatMapping(null, businessWindowStandard, embraer, 2, 'A', null);
        SeatMapping e2c = new SeatMapping(null, businessAisleStandard, embraer, 2, 'C', null);
        SeatMapping e2d = new SeatMapping(null, businessAisleStandard, embraer, 2, 'D', null);
        SeatMapping e2f = new SeatMapping(null, businessWindowStandard, embraer, 2, 'F', null);
        SeatMapping e3a = new SeatMapping(null, businessWindowStandard, embraer, 3, 'A', null);
        SeatMapping e3c = new SeatMapping(null, businessAisleStandard, embraer, 3, 'C', null);
        SeatMapping e3d = new SeatMapping(null, businessAisleStandard, embraer, 3, 'D', null);
        SeatMapping e3f = new SeatMapping(null, businessWindowStandard, embraer, 3, 'F', null);
        SeatMapping e4a = new SeatMapping(null, economyWindow, embraer, 4, 'A', null);
        SeatMapping e4c = new SeatMapping(null, economyAisle, embraer, 4, 'C', null);
        SeatMapping e4d = new SeatMapping(null, economyAisle, embraer, 4, 'D', null);
        SeatMapping e4f = new SeatMapping(null, economyWindow, embraer, 4, 'F', null);
        SeatMapping e5a = new SeatMapping(null, economyWindow, embraer, 5, 'A', null);
        SeatMapping e5c = new SeatMapping(null, economyAisle, embraer, 5, 'C', null);
        SeatMapping e5d = new SeatMapping(null, economyAisle, embraer, 5, 'D', null);
        SeatMapping e5f = new SeatMapping(null, economyWindow, embraer, 5, 'F', null);
        SeatMapping e6a = new SeatMapping(null, economyWindow, embraer, 6, 'A', null);
        SeatMapping e6c = new SeatMapping(null, economyAisle, embraer, 6, 'C', null);
        SeatMapping e6d = new SeatMapping(null, economyAisle, embraer, 6, 'D', null);
        SeatMapping e6f = new SeatMapping(null, economyWindow, embraer, 6, 'F', null);
        SeatMapping e7a = new SeatMapping(null, economyWindow, embraer, 7, 'A', null);
        SeatMapping e7c = new SeatMapping(null, economyAisle, embraer, 7, 'C', null);
        SeatMapping e7d = new SeatMapping(null, economyAisle, embraer, 7, 'D', null);
        SeatMapping e7f = new SeatMapping(null, economyWindow, embraer, 7, 'F', null);
        SeatMapping e8a = new SeatMapping(null, economyWindow, embraer, 8, 'A', null);
        SeatMapping e8c = new SeatMapping(null, economyAisle, embraer, 8, 'C', null);
        SeatMapping e8d = new SeatMapping(null, economyAisle, embraer, 8, 'D', null);
        SeatMapping e8f = new SeatMapping(null, economyWindow, embraer, 8, 'F', null);
        SeatMapping e9a = new SeatMapping(null, economyWindow, embraer, 9, 'A', null);
        SeatMapping e9c = new SeatMapping(null, economyAisle, embraer, 9, 'C', null);
        SeatMapping e9d = new SeatMapping(null, economyAisle, embraer, 9, 'D', null);
        SeatMapping e9f = new SeatMapping(null, economyWindow, embraer, 9, 'F', null);
        SeatMapping e10a = new SeatMapping(null, economyWindow, embraer, 10, 'A', null);
        SeatMapping e10c = new SeatMapping(null, economyAisle, embraer, 10, 'C', null);
        SeatMapping e10d = new SeatMapping(null, economyAisle, embraer, 10, 'D', null);
        SeatMapping e10f = new SeatMapping(null, economyWindow, embraer, 10, 'F', null);
        SeatMapping e11a = new SeatMapping(null, economyWindowExitRow, embraer, 11, 'A', null);
        SeatMapping e11c = new SeatMapping(null, economyAisleExitRow, embraer, 11, 'C', null);
        SeatMapping e11d = new SeatMapping(null, economyAisleExitRow, embraer, 11, 'D', null);
        SeatMapping e11f = new SeatMapping(null, economyWindowExitRow, embraer, 11, 'F', null);
        SeatMapping e12a = new SeatMapping(null, economyWindow, embraer, 12, 'A', null);
        SeatMapping e12c = new SeatMapping(null, economyAisle, embraer, 12, 'C', null);
        SeatMapping e12d = new SeatMapping(null, economyAisle, embraer, 12, 'D', null);
        SeatMapping e12f = new SeatMapping(null, economyWindow, embraer, 12, 'F', null);
        SeatMapping e13a = new SeatMapping(null, economyWindow, embraer, 13, 'A', null);
        SeatMapping e13c = new SeatMapping(null, economyAisle, embraer, 13, 'C', null);
        SeatMapping e13d = new SeatMapping(null, economyAisle, embraer, 13, 'D', null);
        SeatMapping e13f = new SeatMapping(null, economyWindow, embraer, 13, 'F', null);
        SeatMapping e14a = new SeatMapping(null, economyWindow, embraer, 14, 'A', null);
        SeatMapping e14c = new SeatMapping(null, economyAisle, embraer, 14, 'C', null);
        SeatMapping e14d = new SeatMapping(null, economyAisle, embraer, 14, 'D', null);
        SeatMapping e14f = new SeatMapping(null, economyWindow, embraer, 14, 'F', null);

        seatMappingRepository.saveAll(List.of(e1a, e1c, e1d, e1f, e2a, e2c, e2d, e2f, e3a, e3c, e3d, e3f, e4a, e4c, e4d,
                e4f, e5a, e5c, e5d, e5f, e6a, e6c, e6d, e6f, e7a, e7c, e7d, e7f,e8a, e8c, e8d, e8f, e9a, e9c, e9d, e9f, e10a, e10c,
                e10d, e10f, e11a, e11c, e11d, e11f, e12a, e12c, e12d, e12f, e13a, e13c, e13d, e13f, e14a, e14c, e14d, e14f ));

        embraer.getSeatMappings().addAll(List.of(e1a, e1c, e1d, e1f, e2a, e2c, e2d, e2f, e3a, e3c, e3d, e3f, e4a, e4c, e4d,
                        e4f, e5a, e5c, e5d, e5f, e6a, e6c, e6d, e6f, e7a, e7c, e7d, e7f,e8a, e8c, e8d, e8f, e9a, e9c, e9d, e9f, e10a, e10c,
                        e10d, e10f, e11a, e11c, e11d, e11f, e12a, e12c, e12d, e12f, e13a, e13c, e13d, e13f, e14a, e14c, e14d, e14f));

        FlightSchedule fs1 = new FlightSchedule(null, route1, "1-3-5-7", LocalTime.parse("07:55"), LocalTime.parse("09:25"), LocalDate.now(), LocalDate.of(9999, 12, 31), 89, embraer);
        FlightSchedule fs2 = new FlightSchedule(null, route1, "-2-4-6-", LocalTime.parse("12:30"), LocalTime.parse("14:00"), LocalDate.now(), LocalDate.of(9999, 12, 31), 99, embraer);
        FlightSchedule fs3 = new FlightSchedule(null, route2, "12345--", LocalTime.parse("09:00"), LocalTime.parse("09:50"), LocalDate.now(), LocalDate.of(9999, 12, 31), 29, embraer);
        FlightSchedule fs4 = new FlightSchedule(null, route2, "1234567", LocalTime.parse("15:10"), LocalTime.parse("16:00"), LocalDate.now(), LocalDate.of(9999, 12, 31), 49, embraer);
        FlightSchedule fs5 = new FlightSchedule(null, route3, "1--45--", LocalTime.parse("21:20"), LocalTime.parse("22:45"), LocalDate.now(), LocalDate.of(9999, 12, 31), 259, embraer);
        FlightSchedule fs6 = new FlightSchedule(null, route3, "1234567", LocalTime.parse("11:00"), LocalTime.parse("12:25"), LocalDate.now(), LocalDate.of(9999, 12, 31), 229, embraer);
        FlightSchedule fs7 = new FlightSchedule(null, route4, "1234567", LocalTime.parse("06:50"), LocalTime.parse("08:20"), LocalDate.now(), LocalDate.of(9999, 12, 31), 129, embraer);
        FlightSchedule fs8 = new FlightSchedule(null, route4, "1234567", LocalTime.parse("18:35"), LocalTime.parse("20:15"), LocalDate.now(), LocalDate.of(9999, 12, 31), 129, embraer);
        FlightSchedule fs9 = new FlightSchedule(null, route5, "1-3-5-7", LocalTime.parse("07:55"), LocalTime.parse("09:20"), LocalDate.now(), LocalDate.of(9999, 12, 31), 129, embraer);
        FlightSchedule fs10 = new FlightSchedule(null, route5, "-2-4-6-", LocalTime.parse("12:30"), LocalTime.parse("13:55"), LocalDate.now(), LocalDate.of(9999, 12, 31), 129, embraer);

        flightScheduleRepository.saveAll(List.of(fs1, fs2, fs3, fs4, fs5, fs6, fs7, fs8, fs9, fs10));

    }

}
