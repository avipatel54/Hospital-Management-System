package com.hospital.doctor_service.repository;

import com.hospital.doctor_service.dto.DoctorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorDto, String> {
}
