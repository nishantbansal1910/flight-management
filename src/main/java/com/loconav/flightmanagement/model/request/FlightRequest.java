package com.loconav.flightmanagement.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightRequest {

    @JsonProperty("origin")
    @NotBlank(message = "Origin Should Not Be Null")
    private String origin;

    @NotBlank(message = "Destination Should Not Be Null")
    @JsonProperty("destination")
    private String destination;

    @JsonProperty("flight_type")
//    @Enumerated(EnumType.STRING)
    private String flightType;

    @NotNull(message = "Departure Time Should Not Be Null")
    @JsonProperty("departure_time")
    private Long departureTime;

    @NotNull(message = "Arrival Time Should Not Be Null")
    @JsonProperty("arrival_time")
    private Long arrivalTime;

    @NotNull(message = "Number Of Seats Should Not Be Null")
    @JsonProperty("number_of_seats")
    private Integer numberOfSeats;

    @Builder.Default
    @JsonProperty("number_of_seats_booked")
    private Integer numberOfSeatsBooked=0;
}
