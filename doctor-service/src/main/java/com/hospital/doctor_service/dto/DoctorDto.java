package com.hospital.doctor_service.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Doctor")
public class DoctorDto {

    @Id
    private String id;
    private String name;
    private String department;
    private String clinicName;
}
