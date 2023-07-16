package com.loconav.flightmanagement.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loconav.flightmanagement.enums.FlightType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightCreateRequest {

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("destination")
    private String destination;

    @JsonProperty("flight_type")
//    @Enumerated(EnumType.STRING)
    private String flightType;

    @JsonProperty("departure_time")
    private Long departureTime;

    @JsonProperty("arrival_time")
    private Long arrivalTime;

    @JsonProperty("number_of_seats")
    private Integer numberOfSeats;

    @JsonProperty("number_of_seats_booked")
    private Integer numberOfSeatsBooked;
}
