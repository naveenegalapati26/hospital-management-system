package com.hospital.doctor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hospital.doctor.entity.Doctor;
import com.hospital.doctor.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) {
        return service.create(doctor);
    }

    @GetMapping
    public List<Doctor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable Long id) {
        return service.getById(id);
    }
}