package com.farmman.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmman.management.entities.HydroponicSystem;

@Repository
public interface HydroponicSystemRepository extends JpaRepository<HydroponicSystem, Long> {
    // Custom queries if needed
} 