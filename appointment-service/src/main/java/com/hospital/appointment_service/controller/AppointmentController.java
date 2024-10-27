package com.hospital.appointment_service.controller;

import com.hospital.appointment_service.dto.AppointmentDto;
import com.hospital.appointment_service.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity registerDoctor(@RequestBody AppointmentDto appointmentDto){
        appointmentService.register(appointmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDto);
    }
}
