package com.farmman.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmman.management.entities.HydroponicSystem;
import com.farmman.management.repositories.HydroponicSystemRepository;

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

    // Additional logic and methods as needed
}