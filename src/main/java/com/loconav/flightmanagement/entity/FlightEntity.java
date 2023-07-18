package com.loconav.flightmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.loconav.flightmanagement.enums.FlightType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "flights")
@Audited
public class  FlightEntity extends AbstractEntity{
    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "flight_type")
//    @Enumerated(EnumType.STRING)
    private String flightType;

    @Column(name = "departure_time")
    private Long departureTime;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @Column(name = "number_of_seats_booked")
    private Integer numberOfSeatsBooked;

    @Column(name = "arrival_time")
    private Long arrivalTime;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "flightEntity")
    @JsonManagedReference
    List<TicketEntity> tickets;
}
