package com.loconav.flightmanagement.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailsRequest {

    private Long id;


    private String origin;


    private String destination;


//    @Enumerated(EnumType.STRING)
    private String flightType;

}
