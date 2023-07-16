package com.loconav.flightmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "created_at", nullable = false)
    private Long createdAt;


    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;


    @Column(name = "updated_by")
    private String updatedBy;


    @Column(name = "created_by")
    private String createdBy;
    @PrePersist
    protected void onCreate() {
        this.updatedAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).getEpochSecond();
        this.createdAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).getEpochSecond();
        this.createdBy = "System";
        this.updatedBy = "System";
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).getEpochSecond();
        this.updatedBy = "System";
    }
}
