package com.hospital.patient_service.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Patient")
public class PatientDto {

    @Id
    private String id;
    private String name;
    private String email;
    private String contactNo;
}
