package com.segavaDev.tiendaVirtual.util.password_encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DecodePassword {

    private final PasswordEncoder passwordEncoder;

    
    
}
