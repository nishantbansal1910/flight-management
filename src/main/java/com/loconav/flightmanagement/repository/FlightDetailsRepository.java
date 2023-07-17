package com.loconav.flightmanagement.repository;

import com.loconav.flightmanagement.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightEntity, Long> {
    @Query("SELECT f from FlightEntity f WHERE f.id=:id")
    FlightEntity getDetails(Long id);
}
