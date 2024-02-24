package com.farmman.management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmman.management.entities.HydroponicSystem;
import com.farmman.management.services.HydroponicSystemService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/hydroponic-systems")
public class HydroponicSystemController {

    private final HydroponicSystemService service;

    @Autowired
    public HydroponicSystemController(HydroponicSystemService service) {
        this.service = service;
    }
    @PostMapping
    @Operation(summary = "Create a new hydroponic system")
    public ResponseEntity<HydroponicSystem> createSystem(@RequestBody HydroponicSystem system) {
        HydroponicSystem savedSystem = service.saveHydroponicSystem(system);
        return new ResponseEntity<>(savedSystem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a hydroponic system by its ID")
    public ResponseEntity<HydroponicSystem> getSystemById(@PathVariable Long id) {
        return service.findById(id)
            .map(system -> new ResponseEntity<>(system, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<HydroponicSystem> getAllSystems() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSystem(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Additional endpoints as needed
}