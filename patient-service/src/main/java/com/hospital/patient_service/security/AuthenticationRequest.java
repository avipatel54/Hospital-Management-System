package com.hospital.patient_service.security;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class AuthenticationRequest {

    @NotNull
    private String login;

    @NotNull
    private String password;
}
