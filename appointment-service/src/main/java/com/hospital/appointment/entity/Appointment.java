package com.hospital.appointment.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long doctorId;

    private String patientName;

    private LocalDateTime appointmentTime;

    private String status; // BOOKED, CANCELLED

    // 🔹 Default Constructor (Required by JPA)
    public Appointment() {
    }

    // 🔹 Parameterized Constructor
    public Appointment(Long id, Long doctorId, String patientName, 
                       LocalDateTime appointmentTime, String status) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    // 🔹 Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // 🔹 Optional (Good for debugging)
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", patientName='" + patientName + '\'' +
                ", appointmentTime=" + appointmentTime +
                ", status='" + status + '\'' +
                '}';
    }
}