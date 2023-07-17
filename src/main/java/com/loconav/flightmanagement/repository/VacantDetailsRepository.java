package com.loconav.flightmanagement.repository;

import com.loconav.flightmanagement.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VacantDetailsRepository extends JpaRepository<FlightEntity, Long> {
    @Query("SELECT (number_of_seats-number_of_seats_booked) FROM FlightEntity Where id=:id")
    Integer getAvailableSeats(Long id);

}
