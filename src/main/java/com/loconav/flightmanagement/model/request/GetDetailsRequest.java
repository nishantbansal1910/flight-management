package com.loconav.flightmanagement.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetDetailsRequest {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("destination")
    private String destination;

    @JsonProperty("flight_type")
//    @Enumerated(EnumType.STRING)
    private String flightType;

}
