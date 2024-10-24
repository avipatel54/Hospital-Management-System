package com.hospital.appointment_service.dto;

import lombok.Data;

@Data
public class AppointmentDto {

    private String id;
    private String patientName;
    private String doctorName;
    private String clinicName;
    private Long patientContactNo;
}
