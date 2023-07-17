package com.loconav.flightmanagement.service.impl;

import com.loconav.flightmanagement.entity.FlightEntity;
import com.loconav.flightmanagement.model.request.FlightCreateRequest;
import com.loconav.flightmanagement.model.request.FlightDetailsRequest;
import com.loconav.flightmanagement.model.request.GetDetailsRequest;
import com.loconav.flightmanagement.model.request.VacantDetailsRequest;
import com.loconav.flightmanagement.model.response.FlightCreateResponse;
import com.loconav.flightmanagement.model.response.GetDetailsResponse;
import com.loconav.flightmanagement.model.response.VacantDetailsResponse;
import com.loconav.flightmanagement.repository.FlightCreateRepository;
import com.loconav.flightmanagement.repository.FlightDetailsRepository;
import com.loconav.flightmanagement.repository.GetDetailsRepository;
import com.loconav.flightmanagement.repository.VacantDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    FlightCreateRepository flightCreateRepository;

    @Autowired
    VacantDetailsRepository vacantDetailsRepository;

    @Autowired
    FlightDetailsRepository flightDetailsRepository;

    @Autowired
    GetDetailsRepository getDetailsRepository;

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

    public FlightEntity getFlightDetails(FlightDetailsRequest flightDetailsRequest)
    {
        return flightDetailsRepository.getDetails(flightDetailsRequest.getId());
    }

    public GetDetailsResponse getDetailUsingFilter(GetDetailsRequest getDetailsRequest)
    {
        return GetDetailsResponse.builder().response(GetDetailsRepository.get(getDetailsRequest.getFlightType(),
                getDetailsRequest.getDestination(),getDetailsRequest.getOrigin(),
                getDetailsRequest.getId())).build();
    }
}
