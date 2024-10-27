package com.hospital.doctor_service.serviceImpl;

import com.hospital.doctor_service.dto.DoctorDto;
import com.hospital.doctor_service.repository.DoctorRepository;
import com.hospital.doctor_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void register(DoctorDto doctorDto) {
        doctorRepository.save(doctorDto);
    }
}
