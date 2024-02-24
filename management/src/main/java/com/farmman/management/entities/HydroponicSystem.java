package com.farmman.management.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "hydroponic_systems", uniqueConstraints = @UniqueConstraint(columnNames = "location"))
public class HydroponicSystem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 255)
    private String location;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SystemType systemType;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date installationDate;
    
    @Column(nullable = false)
    private Integer capacity;

    // Getters and setters omitted for brevity
    // Implement them to access and modify the fields

    // Enum for system types
    public enum SystemType {
        NUTRIENT_FILM_TECHNIQUE,
        DEEP_WATER_CULTURE,
        EBB_AND_FLOW,
        AEROPONICS,
        DRIP_SYSTEM,
        WICK_SYSTEM,
        AQUAPONICS,
        HYBRID_SYSTEMS,
        VERTICAL_HYDROPONICS,
        KRATKY_METHOD
    }
} 