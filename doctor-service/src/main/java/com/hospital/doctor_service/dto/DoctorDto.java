package com.hospital.doctor_service.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.annotation.processing.Generated;

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
