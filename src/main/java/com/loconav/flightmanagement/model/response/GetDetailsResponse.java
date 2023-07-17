package com.loconav.flightmanagement.model.response;

import com.loconav.flightmanagement.entity.FlightEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetDetailsResponse {
    List<FlightEntity> response;
}
