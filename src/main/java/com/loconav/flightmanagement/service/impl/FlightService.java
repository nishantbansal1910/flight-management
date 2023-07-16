package com.loconav.flightmanagement.service.impl;

import com.loconav.flightmanagement.entity.FlightEntity;
import com.loconav.flightmanagement.model.request.FlightCreateRequest;
import com.loconav.flightmanagement.model.request.VacantDetailsRequest;
import com.loconav.flightmanagement.model.response.FlightCreateResponse;
import com.loconav.flightmanagement.model.response.VacantDetailsResponse;
import com.loconav.flightmanagement.repository.FlightCreateRepository;
import com.loconav.flightmanagement.repository.VacantDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    FlightCreateRepository flightCreateRepository;

    @Autowired
    VacantDetailsRepository vacantDetailsRepository;

    public FlightCreateResponse createNewFlight(FlightCreateRequest flightCreateRequest) {
        FlightEntity flightEntity = FlightEntity.builder().origin(flightCreateRequest.getOrigin())
                .flightType(flightCreateRequest.getFlightType())
                .destination(flightCreateRequest.getDestination())
                .arrivalTime(flightCreateRequest.getArrivalTime())
                .departureTime(flightCreateRequest.getDepartureTime())
                .numberOfSeats(flightCreateRequest.getNumberOfSeats())
                .numberOfSeatsBooked(flightCreateRequest.getNumberOfSeatsBooked()).build();

        flightCreateRepository.save(flightEntity);

        return FlightCreateResponse.builder().response("Success").build();
    }

    public VacantDetailsResponse vacantDetails(VacantDetailsRequest vacantDetailsRequest) {
        return VacantDetailsResponse.builder().response(
                "number of available seats are " + vacantDetailsRepository.getAvailableSeats(
                        vacantDetailsRequest.getId())).build();
    }
}
