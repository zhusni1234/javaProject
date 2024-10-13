package com.example.sash;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF and enable CORS
        http.csrf().disable()
            .cors() // Enable CORS with settings from WebConfig
            .and()
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/admin/**").authenticated()  // Secure admin routes
                .anyRequest().permitAll()  // Allow other requests
            );

        return http.build();
    }
}
