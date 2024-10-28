package com.hospital.appointment_service.controller;

import com.hospital.appointment_service.dto.AppointmentDto;
import com.hospital.appointment_service.dto.AuthenticationRequest;
import com.hospital.appointment_service.serviceImpl.JwtAuthenticationService;
import com.hospital.appointment_service.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtUtil jwtService;

    private final JwtAuthenticationService authenticationService;

    public AuthenticationController(JwtUtil jwtService, JwtAuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    @PostMapping("/login")
    public String authenticate(@RequestBody AuthenticationRequest loginUserDto) {

        String authenticatedUser = authenticationService.authenticate(loginUserDto.getUserName(),loginUserDto.getPassword());

        return authenticatedUser;
    }
}