package com.loconav.flightmanagement.service.impl;

import com.loconav.flightmanagement.entity.FlightEntity;
import com.loconav.flightmanagement.entity.TicketEntity;
import com.loconav.flightmanagement.model.request.TicketCreateRequest;
import com.loconav.flightmanagement.model.response.TicketCreateResponse;
import com.loconav.flightmanagement.repository.FlightDetailsRepository;
import com.loconav.flightmanagement.repository.TicketCreateRepository;
import com.loconav.flightmanagement.repository.VacantDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketCreateRepository ticketCreateRepository;

    @Autowired
    VacantDetailsRepository vacantDetailsRepository;

    @Autowired
    FlightDetailsRepository flightDetailsRepository;

    public TicketCreateResponse createTicket(TicketCreateRequest ticketCreateRequest)
    {
        if(vacantDetailsRepository.getAvailableSeats(ticketCreateRequest.getFlightId())==0)
        {
            return TicketCreateResponse.builder().response("Sorry All Seats Are Booked").build();
        }
        TicketEntity ticketEntity=
                com.loconav.flightmanagement.entity.TicketEntity.builder().name(ticketCreateRequest.getName()).flightEntity(flightDetailsRepository.getDetails(ticketCreateRequest.getFlightId())).build();
        ticketCreateRepository.save(ticketEntity);
        return TicketCreateResponse.builder().response("Ticket Generated").build();
    }
}
