package com.hospital.patient.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.hospital.patient.entity.Patient;
import com.hospital.patient.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    // Constructor Injection (Manual)
    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return service.create(patient);
    }

    @GetMapping
    public List<Patient> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id) {
        return service.getById(id);
    }
}