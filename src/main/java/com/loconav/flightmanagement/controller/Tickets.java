package com.loconav.flightmanagement.controller;

import com.loconav.flightmanagement.model.request.TicketCreateRequest;
import com.loconav.flightmanagement.model.response.TicketCreateResponse;
import com.loconav.flightmanagement.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets/")
public class Tickets {
    @Autowired
    TicketService ticketService;
    @PostMapping("create_ticket")
    public TicketCreateResponse FlightTicket(@RequestBody TicketCreateRequest ticketCreateRequest)
    {
        return ticketService.createTicket(ticketCreateRequest);
    }

}
