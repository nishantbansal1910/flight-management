package com.loconav.flightmanagement.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("flight_id")
    private Long flightId;
}
