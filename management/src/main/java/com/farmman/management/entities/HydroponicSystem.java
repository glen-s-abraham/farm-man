package com.farmman.management.entities;

import io.swagger.v3.oas.annotations.media.Schema;
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

import java.io.Serializable;
import java.util.Date;

import com.farmman.management.entities.enums.SystemType;

@Entity
@Table(name = "hydroponic_systems")
@Schema(description = "Entity representing a hydroponic system.")
public class HydroponicSystem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the hydroponic system.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false, length = 255)
    @Schema(description = "Location of the hydroponic system.", example = "Greenhouse 3", required = true)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "Type of the hydroponic system.", example = "NUTRIENT_FILM_TECHNIQUE", required = true)
    private SystemType systemType;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @Schema(description = "Installation date of the system.", example = "2023-01-15", required = true, format = "date")
    private Date installationDate;

    @Column(nullable = false)
    @Schema(description = "Capacity of the system in terms of plant support.", example = "200", required = true)
    private Integer capacity;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SystemType getSystemType() {
        return systemType;
    }

    public void setSystemType(SystemType systemType) {
        this.systemType = systemType;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public HydroponicSystem() {
    }

    public HydroponicSystem(String location, SystemType systemType, Date installationDate, Integer capacity) {
        this.location = location;
        this.systemType = systemType;
        this.installationDate = installationDate;
        this.capacity = capacity;
    }
}