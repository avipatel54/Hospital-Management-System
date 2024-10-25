package com.hospital.appointment_service.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Appointment")
public class AppointmentDto {

    @Id
    private String id;
    private String patientName;
    private String doctorName;
    private String clinicName;
    private Long patientContactNo;
}
