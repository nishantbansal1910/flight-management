package com.loconav.flightmanagement.controller;

import com.loconav.flightmanagement.model.request.FlightCreateRequest;
import com.loconav.flightmanagement.model.request.VacantDetailsRequest;
import com.loconav.flightmanagement.model.response.FlightCreateResponse;
import com.loconav.flightmanagement.model.response.VacantDetailsResponse;
import com.loconav.flightmanagement.service.impl.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flights/")
public class Flights {
    @Autowired
    FlightService flightService;
    @PostMapping("flight_details")
    public FlightCreateResponse createFlight(@RequestBody FlightCreateRequest flightCreateRequest)
    {
        return flightService.createNewFlight(flightCreateRequest);
    }

    @GetMapping("vacant_seats")
    public VacantDetailsResponse vacant(@RequestParam(name="id")final Long id)
    {
        VacantDetailsRequest vacantDetailsRequest=VacantDetailsRequest.builder().id(id).build();
        return flightService.vacantDetails(vacantDetailsRequest);
    }
}
