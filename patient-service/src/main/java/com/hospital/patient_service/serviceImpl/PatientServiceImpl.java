package com.hospital.patient_service.serviceImpl;
import com.hospital.patient_service.dto.PatientDto;
import com.hospital.patient_service.repository.PatientRepository;
import com.hospital.patient_service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void register(PatientDto patientDto) {
        patientRepository.save(patientDto);
    }
}
