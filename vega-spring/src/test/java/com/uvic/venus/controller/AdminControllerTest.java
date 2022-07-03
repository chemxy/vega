package com.uvic.venus.controller;

import com.uvic.venus.model.UserInfo;
import com.uvic.venus.repository.UserInfoDAO;
import com.uvic.venus.storage.StorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class AdminControllerTest {

    @InjectMocks
    AdminController AC;

    @Mock
    UserInfoDAO dao;

    @Mock
    DataSource DS;

    @Mock
    StorageService SS;

    @Mock
    JdbcUserDetailsManager JBDCM;

    @Test
    void fetchAllUsers() {
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        UserInfo userOne = new UserInfo("user1", "User", "One");
        UserInfo userTwo = new UserInfo("user1", "User", "Two");
        UserInfo userThree = new UserInfo("user1", "User", "Three");

        userInfoList.add(userOne);
        userInfoList.add(userTwo);
        userInfoList.add(userThree);

        when(dao.findAll()).thenReturn(userInfoList);

        ResponseEntity<?> responseEntity = AC.fetchAllUsers();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(3, ((List) responseEntity.getBody()).size());
        verify(dao, times(1)).findAll();
    }

    @Test
    void enableUserAccount() throws SQLException {
//        ResponseEntity<?> responseEntity = AC.enableUserAccount("user1", true);
//
//        assertEquals(200, responseEntity.getStatusCodeValue());
//        assertEquals("User Updated Successfully", (responseEntity.getBody()).toString());
//        verify(DS, times(1));
    }

    @Test
    void changeRole() {
    }

    @Test
    void handleFileUpload() {
        MockMultipartFile file = new MockMultipartFile("file", (byte[]) null);

        ResponseEntity<?> responseEntity = AC.handleFileUpload(file);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("File uploaded Successfully", (responseEntity.getBody()).toString());
        verify(SS, times(1)).store(file);
    }
}