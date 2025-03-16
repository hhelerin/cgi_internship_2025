package com.example.cgi_internship_2025.service;

import com.example.cgi_internship_2025.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    //TODO: saveTicket
}
