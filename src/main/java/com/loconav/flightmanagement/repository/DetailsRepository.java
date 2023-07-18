package com.loconav.flightmanagement.repository;

import com.loconav.flightmanagement.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsRepository extends JpaRepository<FlightEntity, Long> {
    @Query(value = "SELECT * FROM flights f WHERE (:id IS null OR f.id=:id) AND ("
           + ":destination IS null OR f.destination=:destination) AND (:origin IS null OR "
           + "f.origin=:origin)"
           + " AND (:flightType IS null OR f.flight_type=:flightType)",nativeQuery = true)
    List<FlightEntity> getFlights(String flightType,
                           String destination,
                           String origin,
                           Long id);
}
