package com.farmman.management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmman.management.entities.HydroponicSystem;
import com.farmman.management.services.HydroponicSystemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.EntityNotFoundException;

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
    @Operation(
        summary = "Create a new hydroponic system",
        responses = {
            @ApiResponse(description = "Created", responseCode = "201", 
                content = @Content(schema = @Schema(implementation = HydroponicSystem.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400")
        }
    )
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

    @PutMapping("/{id}")
    @Operation(
        summary = "Update an existing hydroponic system by its ID",
        responses = {
            @ApiResponse(description = "OK", responseCode = "200", 
                content = @Content(schema = @Schema(implementation = HydroponicSystem.class))),
            @ApiResponse(description = "Not Found", responseCode = "404"),
            @ApiResponse(description = "Bad Request", responseCode = "400")
        }
    )
    public ResponseEntity<HydroponicSystem> updateSystem(@PathVariable Long id, @RequestBody HydroponicSystem newSystemData) {
        try {
            HydroponicSystem updatedSystem = service.updateHydroponicSystem(id, newSystemData);
            return ResponseEntity.ok(updatedSystem);
        } catch (EntityNotFoundException e) {
            // Handle the case where the hydroponic system with the given ID doesn't exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}