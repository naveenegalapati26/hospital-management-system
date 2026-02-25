package com.hospital.appointment.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.hospital.appointment.entity.Appointment;
import com.hospital.appointment.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    // Constructor Injection
    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    // 🔹 POST → Create
    @PostMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return service.createAppointment(appointment);
    }

    // 🔹 GET → Get All
    @GetMapping
    public List<Appointment> getAll() {
        return service.getAllAppointments();
    }

    // 🔹 GET → Get By ID
    @GetMapping("/{id}")
    public Appointment getById(@PathVariable Long id) {
        return service.getAppointmentById(id);
    }

    // 🔹 PUT → Update
    @PutMapping("/{id}")
    public Appointment update(@PathVariable Long id,
                              @RequestBody Appointment appointment) {
        return service.updateAppointment(id, appointment);
    }

    // 🔹 DELETE → Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteAppointment(id);
        return "Appointment deleted successfully";
    }
}