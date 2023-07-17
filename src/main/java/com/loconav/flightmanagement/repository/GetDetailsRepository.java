package com.loconav.flightmanagement.repository;

import com.loconav.flightmanagement.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetDetailsRepository extends JpaRepository<FlightEntity, Long> {
    @Query("")
    List<FlightEntity> get(String flightType,String destination,String origin,Long id);
}
