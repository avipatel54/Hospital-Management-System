package com.hospital.appointment_service.repository;

import com.hospital.appointment_service.dto.AppointmentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentDto, String> {
}
