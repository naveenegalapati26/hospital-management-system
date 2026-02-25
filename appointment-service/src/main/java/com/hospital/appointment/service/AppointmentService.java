package com.hospital.appointment.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.hospital.appointment.entity.Appointment;
import com.hospital.appointment.repository.AppointmentRepository;
import com.hospital.appointment.client.DoctorClient;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;
    private final DoctorClient doctorClient;

    // Constructor Injection
    public AppointmentService(AppointmentRepository repository,
                              DoctorClient doctorClient) {
        this.repository = repository;
        this.doctorClient = doctorClient;
    }

    // CREATE
    public Appointment createAppointment(Appointment appointment) {

        // 🔥 Call doctor-service before saving
        Object doctor = doctorClient.getDoctorById(appointment.getDoctorId());

        if (doctor == null) {
            throw new RuntimeException("Doctor not found with id: " 
                                        + appointment.getDoctorId());
        }

        appointment.setStatus("BOOKED");
        return repository.save(appointment);
    }

    // READ ALL
    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    // READ BY ID
    public Appointment getAppointmentById(Long id) {
        Optional<Appointment> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
    }

    // UPDATE
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment existing = getAppointmentById(id);

        existing.setDoctorId(updatedAppointment.getDoctorId());
        existing.setPatientName(updatedAppointment.getPatientName());
        existing.setAppointmentTime(updatedAppointment.getAppointmentTime());
        existing.setStatus(updatedAppointment.getStatus());

        return repository.save(existing);
    }

    // DELETE
    public void deleteAppointment(Long id) {
        repository.deleteById(id);
    }
}