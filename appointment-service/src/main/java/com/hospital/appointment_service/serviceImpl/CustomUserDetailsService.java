//package com.hospital.appointment_service.serviceImpl;
//
//import com.hospital.appointment_service.dto.AppointmentDto;
//import com.hospital.appointment_service.repository.AppointmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class CustomUserDetailsService {
//
//    @Autowired
//    private AppointmentRepository appointmentRepository;
//
//    public UserDetails loadUserDetails(String userName){
//        AppointmentDto appointmentDto=appointmentRepository.findByPatientName(userName);
//        return new org.springframework.security.core.userdetails.User(appointmentDto.getPatientName(),"test", new ArrayList<>());
//    }
//}
