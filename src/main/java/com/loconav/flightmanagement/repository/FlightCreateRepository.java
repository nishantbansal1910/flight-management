package com.loconav.flightmanagement.repository;

import com.loconav.flightmanagement.controller.Flights;
import com.loconav.flightmanagement.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository public interface FlightCreateRepository extends JpaRepository<FlightEntity, Long> {

}