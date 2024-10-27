package com.hospital.appointment_service.serviceImpl;

import com.hospital.appointment_service.dto.AppointmentDto;
import com.hospital.appointment_service.repository.AppointmentRepository;
import com.hospital.appointment_service.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void register(AppointmentDto appointmentDto) {
        appointmentRepository.save(appointmentDto);
    }
}
