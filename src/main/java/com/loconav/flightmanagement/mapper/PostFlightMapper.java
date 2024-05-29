package com.loconav.flightmanagement.mapper;

import com.loconav.flightmanagement.entity.FlightEntity;
import com.loconav.flightmanagement.model.response.DetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface PostFlightMapper {
    PostFlightMapper INSTANCE= Mappers.getMapper(PostFlightMapper.class);
    List<DetailsResponse> mapFlight(final List<FlightEntity> flight);
}
