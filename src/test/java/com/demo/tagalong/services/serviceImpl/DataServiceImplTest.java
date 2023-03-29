package com.demo.tagalong.services.serviceImpl;

import com.demo.tagalong.dto.ApiResponse;
import com.demo.tagalong.dto.RequestDto;
import com.demo.tagalong.exceptions.FailedToCreateDataException;
import com.demo.tagalong.exceptions.NoDataFoundException;
import com.demo.tagalong.services.DataService;
import com.demo.tagalong.utils.ResponseManager;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class DataServiceImplTest {

        @Mock
        private ResponseManager responseManager;

        @InjectMocks
        private DataService dataService = new DataServiceImpl();

        @Before
        public void setUp() throws Exception {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testCreateData_Success() {
            RequestDto request = new RequestDto();
            ApiResponse expectedResponse = new ApiResponse();
            when(responseManager.requestSuccessful(HttpStatus.CREATED, new HashMap<>())).thenReturn(expectedResponse);

            ApiResponse actualResponse = dataService.createData(request);

            assertEquals(expectedResponse, actualResponse);
            verify(responseManager).requestSuccessful(HttpStatus.CREATED, new HashMap<>());
            verifyNoMoreInteractions(responseManager);
        }

        @Test
        public void testGetData_Success() {
            String email = "test@test.com";
            String password = "password";
            ApiResponse expectedResponse = new ApiResponse();
            when(responseManager.requestSuccessful(HttpStatus.FOUND, new HashMap<>())).thenReturn(expectedResponse);

            ApiResponse actualResponse = dataService.getData(email, password);

            assertEquals(expectedResponse, actualResponse);
            verify(responseManager).requestSuccessful(HttpStatus.FOUND, new HashMap<>());
            verifyNoMoreInteractions(responseManager);
        }
}