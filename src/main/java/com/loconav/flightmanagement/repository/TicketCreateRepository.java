package com.loconav.flightmanagement.repository;

import com.loconav.flightmanagement.entity.FlightEntity;
import com.loconav.flightmanagement.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCreateRepository extends JpaRepository<TicketEntity, Long>{

}
