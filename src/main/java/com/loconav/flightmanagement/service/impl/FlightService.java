package com.loconav.flightmanagement.service.impl;

import com.loconav.flightmanagement.entity.FlightEntity;
import com.loconav.flightmanagement.mapper.PostFlightMapper;
import com.loconav.flightmanagement.model.request.FlightRequest;
import com.loconav.flightmanagement.model.request.FlightDetailsRequest;
import com.loconav.flightmanagement.model.request.DetailsRequest;
import com.loconav.flightmanagement.model.request.VacantDetailsRequest;
import com.loconav.flightmanagement.model.response.FlightResponse;
import com.loconav.flightmanagement.model.response.DetailsResponse;
import com.loconav.flightmanagement.model.response.VacantDetailsResponse;
import com.loconav.flightmanagement.repository.FlightCreateRepository;
import com.loconav.flightmanagement.repository.FlightDetailsRepository;
import com.loconav.flightmanagement.repository.DetailsRepository;
import com.loconav.flightmanagement.repository.VacantDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    DetailsRepository detailsRepository;

    @Autowired
    PostFlightMapper postFlightMapper;

    public FlightResponse NewFlight(FlightRequest flightCreateRequest) {
        FlightEntity flightEntity = FlightEntity.builder().origin(flightCreateRequest.getOrigin())
                .flightType(flightCreateRequest.getFlightType())
                .destination(flightCreateRequest.getDestination())
                .arrivalTime(flightCreateRequest.getArrivalTime())
                .departureTime(flightCreateRequest.getDepartureTime())
                .numberOfSeats(flightCreateRequest.getNumberOfSeats())
                .numberOfSeatsBooked(flightCreateRequest.getNumberOfSeatsBooked()).build();

        flightCreateRepository.save(flightEntity);

        return FlightResponse.builder().response("Success").build();
    }

    public VacantDetailsResponse vacantDetails(VacantDetailsRequest vacantDetailsRequest) {
        return VacantDetailsResponse.builder().response(
                "number of available seats are " + vacantDetailsRepository.availableSeats(
                        vacantDetailsRequest.getId())).build();
    }

    public Optional<FlightEntity> FlightDetails(FlightDetailsRequest flightDetailsRequest)
    {
        return flightDetailsRepository.details(flightDetailsRequest.getId());
    }

    public List<DetailsResponse> listDetails(DetailsRequest getDetailsRequest)
    {
        System.out.println(getDetailsRequest);


        return postFlightMapper.mapFlight(detailsRepository.getFlights(getDetailsRequest.getFlightType(),
                getDetailsRequest.getDestination(),getDetailsRequest.getOrigin(),
                getDetailsRequest.getId()));
    }
}
