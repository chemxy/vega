package com.uvic.venus.config;

import com.uvic.venus.auth.JwtTokenFilter;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

import static org.mockito.Mockito.*;

class SecurityConfigurationTest {

    AuthenticationManagerBuilder auth = mock(AuthenticationManagerBuilder.class);
    DataSource dataSource = mock(DataSource.class);

    SecurityConfiguration securityConfiguration = new SecurityConfiguration();

    @Test
    void configureGlobal() {
        try {
            JdbcUserDetailsManagerConfigurer jdbc = mock(JdbcUserDetailsManagerConfigurer.class);
            when(auth.jdbcAuthentication()).thenReturn(jdbc);
            securityConfiguration.configureGlobal(auth);
            verify(auth.jdbcAuthentication());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void configure() {
    }

    @Test
    void authenticationManagerBean() {
    }

    @Test
    void passwordEncoder() {
        PasswordEncoder encoder = securityConfiguration.passwordEncoder();
        assert(encoder != null);
    }
}