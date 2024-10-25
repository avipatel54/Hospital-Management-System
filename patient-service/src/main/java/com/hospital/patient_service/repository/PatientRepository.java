package com.hospital.patient_service.repository;

import com.hospital.patient_service.dto.PatientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientDto, String> {
}
