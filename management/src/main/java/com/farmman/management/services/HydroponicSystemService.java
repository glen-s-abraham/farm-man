package com.farmman.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmman.management.entities.HydroponicSystem;
import com.farmman.management.repositories.HydroponicSystemRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HydroponicSystemService {

    private final HydroponicSystemRepository repository;

    @Autowired
    public HydroponicSystemService(HydroponicSystemRepository repository) {
        this.repository = repository;
    }

    public HydroponicSystem saveHydroponicSystem(HydroponicSystem system) {
        return repository.save(system);
    }

    public Optional<HydroponicSystem> findById(Long id) {
        return repository.findById(id);
    }

    public List<HydroponicSystem> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public HydroponicSystem updateHydroponicSystem(Long id, HydroponicSystem newSystemData) {
        return repository.findById(id).map(existingSystem -> {
            // Update the existing system with the values from newSystemData
            // Assuming newSystemData contains only the fields that should be updated
            existingSystem.setLocation(newSystemData.getLocation());
            existingSystem.setSystemType(newSystemData.getSystemType());
            existingSystem.setInstallationDate(newSystemData.getInstallationDate());
            existingSystem.setCapacity(newSystemData.getCapacity());
            // If there are more fields that can be updated, add them here

            // Save the updated system
            return repository.save(existingSystem);
        }).orElseThrow(() -> new EntityNotFoundException("Hydroponic system with id " + id + " not found."));
    }
}