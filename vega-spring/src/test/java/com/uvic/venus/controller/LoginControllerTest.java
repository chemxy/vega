package com.uvic.venus.controller;

import com.uvic.venus.model.AuthenticationRequest;
import com.uvic.venus.model.RegisterUserInfo;
import com.uvic.venus.repository.UserInfoDAO;
import com.uvic.venus.storage.StorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)


class LoginControllerTest {
    @InjectMocks
    AdminController AC;

    @Mock
    FileController FC;

    @Mock
    StorageService SS;

    @Mock
    UserInfoDAO dao;

    @Mock
    private LoginController LC;


    @Test
    void registerUser() throws Exception {
        RegisterUserInfo user = new RegisterUserInfo("user", "first", "last", "pass");

        ResponseEntity<?> responseEntity = LC.registerUser(user);
        //assertEquals("User registered", responseEntity.getBody());
        System.out.println(responseEntity);
    }

    @Test
    void createAuthenticationToken() throws Exception {
        AuthenticationRequest request = new AuthenticationRequest("user", "pass");
        ResponseEntity<?> responseEntity = LC.createAuthenticationToken(request);
        System.out.println(responseEntity);
        //assertEquals("Token Created", responseEntity.getBody());

    }
}