package com.uvic.venus.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

import static org.mockito.Mockito.*;

class SecurityConfigurationTest {

    AuthenticationManagerBuilder auth = mock(AuthenticationManagerBuilder.class);
    SecurityConfiguration securityConfiguration = new SecurityConfiguration();

    @Test
    //Unit test for SecurityConfiguration.passwordEncoder
    void passwordEncoder() {
        PasswordEncoder encoder = securityConfiguration.passwordEncoder();
        assert(encoder != null);
    }
    @Test
    //Unit test for SecurityConfiguration.configureGlobal
    void configureGlobal() {
        JdbcUserDetailsManagerConfigurer jdbc = mock(JdbcUserDetailsManagerConfigurer.class);
        try {
            when(auth.jdbcAuthentication()).thenReturn(jdbc);
            securityConfiguration.configureGlobal(auth);
            verify(auth).jdbcAuthentication();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //The remaining methods in SecurityConfiguration.java require integration testing rather than unit testing
}