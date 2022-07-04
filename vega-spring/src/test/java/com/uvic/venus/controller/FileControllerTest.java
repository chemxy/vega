package com.uvic.venus.controller;

import com.uvic.venus.storage.StorageService;
import org.h2.util.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)

class FileControllerTest {
    @InjectMocks
    FileController FC;

    @Mock
    StorageService SS;
    private ResourceLoader resourceLoader;

    @Test
    void listUploadedFiles() {
        MockMultipartFile file = new MockMultipartFile("file", (byte[]) null);
        SS.store(file);
        ResponseEntity<?> responseEntity = FC.listUploadedFiles();
        assertEquals(200, responseEntity.getStatusCodeValue());
        verify(SS, times(1)).loadAll();
    }

    @Test
    void serveFile() throws MalformedURLException {
        Resource res = new FileUrlResource("file:d:/test.txt");
        when(SS.loadAsResource(any())).thenReturn(res);
        ResponseEntity<?> responseEntity = FC.serveFile("file.txt");
        assertEquals(200, responseEntity.getStatusCodeValue());
        verify(SS, times(1)).loadAsResource("file.txt");
    }
}