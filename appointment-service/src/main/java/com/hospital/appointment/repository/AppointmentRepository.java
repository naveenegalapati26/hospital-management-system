package com.hospital.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.appointment.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}