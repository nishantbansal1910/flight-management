package com.loconav.flightmanagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailsResponse {

    private String origin;


    private String destination;


    //    @Enumerated(EnumType.STRING)
    private String flightType;


    private Long departureTime;


    private Integer numberOfSeats;


    private Integer numberOfSeatsBooked;


    private Long arrivalTime;
}
