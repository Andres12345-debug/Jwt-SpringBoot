package com.example.jwt2.Config;

import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()).authorizeHttpRequests(authRequest -> authRequest.requestMatchers("/auth/**").permitAll().anyRequest().authenticated()                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
