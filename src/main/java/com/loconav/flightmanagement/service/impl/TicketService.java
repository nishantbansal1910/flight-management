package com.loconav.flightmanagement.service.impl;

import com.loconav.flightmanagement.entity.TicketEntity;
import com.loconav.flightmanagement.model.request.TicketRequest;
import com.loconav.flightmanagement.model.response.TicketResponse;
import com.loconav.flightmanagement.repository.FlightDetailsRepository;
import com.loconav.flightmanagement.repository.TicketCreateRepository;
import com.loconav.flightmanagement.repository.VacantDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketCreateRepository ticketCreateRepository;

    @Autowired
    VacantDetailsRepository vacantDetailsRepository;

    @Autowired
    FlightDetailsRepository flightDetailsRepository;

    public TicketResponse addTicket(TicketRequest ticketRequest)
    {
        if(vacantDetailsRepository.availableSeats(ticketRequest.getFlightId()) == 0)
        {
            return TicketResponse.builder().response("Sorry All Seats Are Booked").build();
        }
        TicketEntity ticketEntity=
                com.loconav.flightmanagement.entity.TicketEntity.builder().name(ticketRequest.getName()).flightEntity(flightDetailsRepository.find(
                        ticketRequest.getFlightId())).build();
        ticketCreateRepository.save(ticketEntity);
        return TicketResponse.builder().response("Ticket Generated").build();
    }
}
