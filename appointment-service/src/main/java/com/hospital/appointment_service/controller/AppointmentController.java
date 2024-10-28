package com.hospital.appointment_service.controller;

import com.hospital.appointment_service.dto.AppointmentDto;
import com.hospital.appointment_service.dto.AuthenticationRequest;
import com.hospital.appointment_service.service.AppointmentService;
import com.hospital.appointment_service.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity registerDoctor(@RequestBody AppointmentDto appointmentDto){
        try {
            appointmentService.register(appointmentDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDto);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
