package com.hospital.patient.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.hospital.patient.entity.Patient;
import com.hospital.patient.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient create(Patient patient) {
        return repository.save(patient);
    }
    
    public List<Patient> getAll() {
        return repository.findAll();
    }

    public Patient getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not at all  found"));
    }
}