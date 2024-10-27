package com.hospital.patient_service.controller;

import com.hospital.patient_service.dto.PatientDto;
import com.hospital.patient_service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity registerDoctor(@RequestBody PatientDto patientDto){
        patientService.register(patientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDto);
    }
}
