package com.uvic.venus.controller;

import com.uvic.venus.model.UserInfo;
import com.uvic.venus.repository.UserInfoDAO;
import com.uvic.venus.storage.StorageService;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminControllerTest {

    @InjectMocks
    AdminController AC;

    @Mock
    UserInfoDAO dao;

    @Mock
    DataSource DS;

    @Mock
    StorageService SS;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void fetchAllUsers() {
//        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
//        UserInfo userOne = new UserInfo("user1", "User", "One");
//        UserInfo userTwo = new UserInfo("user1", "User", "Two");
//        UserInfo userThree = new UserInfo("user1", "User", "Three");
//
//        userInfoList.add(userOne);
//        userInfoList.add(userTwo);
//        userInfoList.add(userThree);
//
//        when(dao.findAll()).thenReturn(userInfoList);
//
//        List<UserInfo> userList = dao.findAll();
//
//        when(AC.fetchAllUsers()).thenReturn(ResponseEntity.ok(userList));
//
//        ResponseEntity<?> resp = AC.fetchAllUsers();
//
//        assertEquals(200, resp.getStatusCode());
////        assertEquals(3, resp.);
//        verify(dao, times(1)).findAll();
    }

    @Test
    void enableUserAccount() {
    }

    @Test
    void changeRole() {
    }

    @Test
    void handleFileUpload() {
    }
}