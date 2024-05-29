package com.loconav.flightmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tickets")
@Audited
public class TicketEntity extends AbstractEntity{
    @Column(name = "name")
    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    @JsonManagedReference
    private FlightEntity flightEntity;

    @PrePersist
    protected void onUpdate(){
        flightEntity.getTickets().add(this);
        this.flightEntity.setNumberOfSeatsBooked(this.flightEntity.getNumberOfSeatsBooked()+1);
    }

}
