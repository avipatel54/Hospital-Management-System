package com.hospital.doctor_service.controller;

import com.hospital.doctor_service.dto.DoctorDto;
import com.hospital.doctor_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity registerDoctor(@RequestBody DoctorDto doctorDto){
        doctorService.register(doctorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorDto);
    }
}
