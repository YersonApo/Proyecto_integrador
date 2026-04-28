package com.miapi.proyectoIntegrador.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Codificador {

    @Bean
    public PasswordEncoder codi() {
        return new BCryptPasswordEncoder();
    }
}
