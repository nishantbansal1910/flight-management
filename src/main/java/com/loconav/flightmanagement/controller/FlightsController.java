package com.loconav.flightmanagement.controller;

import com.loconav.flightmanagement.entity.FlightEntity;
import com.loconav.flightmanagement.model.request.FlightRequest;
import com.loconav.flightmanagement.model.request.FlightDetailsRequest;
import com.loconav.flightmanagement.model.request.DetailsRequest;
import com.loconav.flightmanagement.model.request.VacantDetailsRequest;
import com.loconav.flightmanagement.model.response.FlightResponse;
import com.loconav.flightmanagement.model.response.DetailsResponse;
import com.loconav.flightmanagement.model.response.VacantDetailsResponse;
import com.loconav.flightmanagement.service.impl.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/flights/")
public class FlightsController {
    @Autowired
    FlightService flightService;
    @PostMapping("flight_details")
    public FlightResponse addFlight(@Valid @RequestBody FlightRequest flightCreateRequest)
    {
        return flightService.NewFlight(flightCreateRequest);
    }

    /***
     *
     * @param id
     * @return
     */
    @GetMapping("vacant_seats")
    public VacantDetailsResponse vacant(@RequestParam(name="id")final Long id)
    {
        VacantDetailsRequest vacantDetailsRequest=VacantDetailsRequest.builder().id(id).build();
        return flightService.vacantDetails(vacantDetailsRequest);
    }

    @GetMapping("get_details")
    public Optional<FlightEntity> Details(@RequestParam(name="id")final Long id)
    {
        return flightService.FlightDetails(FlightDetailsRequest.builder().id(id).build());
    }

    @GetMapping("get_filtered_details")
    public List<DetailsResponse> fetchDetails(@RequestParam(name="origin",required = false)final String origin,
                                         @RequestParam(name="id",required = false)final Long id,
                                         @RequestParam(name="destination",required = false)final String destination,
                                         @RequestParam(name="flight_type",required = false)final String flightType)
    {
        return flightService.listDetails(
                DetailsRequest.builder().id(id).origin(origin).flightType(flightType).destination(destination).build());
    }
}
