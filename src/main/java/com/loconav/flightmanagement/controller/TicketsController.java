package com.loconav.flightmanagement.controller;

import com.loconav.flightmanagement.model.request.TicketRequest;
import com.loconav.flightmanagement.model.response.TicketResponse;
import com.loconav.flightmanagement.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets/")
public class TicketsController {
    @Autowired
    TicketService ticketService;
    @PostMapping("create_ticket")
    public TicketResponse FlightTicket(@RequestBody TicketRequest ticketRequest)
    {
        return ticketService.addTicket(ticketRequest);
    }

}
