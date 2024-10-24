package com.hospital.patient_service.dto;

import lombok.Data;

@Data
public class PatientDto {

    private String id;
    private String name;
    private String email;
    private Long contactNo;
}
