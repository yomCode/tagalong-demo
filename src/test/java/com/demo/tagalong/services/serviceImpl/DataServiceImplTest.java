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
            ApiResponse expectedResponse = new ApiResponse(new HashMap<>(), true, HttpStatus.CREATED);
            when(responseManager.requestSuccessful(HttpStatus.CREATED, new HashMap<>())).thenReturn(expectedResponse);

            ApiResponse actualResponse = dataService.createData(request);

            assertEquals(expectedResponse, actualResponse);
            verify(responseManager).requestSuccessful(HttpStatus.CREATED, new HashMap<>());
            verifyNoMoreInteractions(responseManager);
        }


    @Test
    void testCreateDataWithException() {
        RequestDto request = new RequestDto();
        request.setEmail("demo@gmail.com");
        request.setPassword("2345432");

        when(responseManager.requestSuccessful(HttpStatus.CREATED, new HashMap<>()))
                .thenThrow(new RuntimeException("An errored while trying to create data \n Please try again later."));

        assertThrows(FailedToCreateDataException.class, () -> dataService.createData(request));
    }

        @Test
        public void testGetData_Success() {
            String email = "demo@gmail.com";
            String password = "44323454";
            ApiResponse expectedResponse = new ApiResponse(new HashMap<>(), true, HttpStatus.FOUND);
            when(responseManager.requestSuccessful(HttpStatus.FOUND, new HashMap<>())).thenReturn(expectedResponse);

            ApiResponse actualResponse = dataService.getData(email, password);

            assertEquals(expectedResponse, actualResponse);
            verify(responseManager).requestSuccessful(HttpStatus.FOUND, new HashMap<>());
            verifyNoMoreInteractions(responseManager);
        }


    @Test
    void testGetDataWithException() {
        String email = "demo@gmail.com";
        String password = "454345";

        when(responseManager.requestSuccessful(HttpStatus.FOUND, new HashMap<>()))
                .thenThrow(new RuntimeException("An error occurred while trying to retrieve data"));


        assertThrows(NoDataFoundException.class, () -> dataService.getData(email, password));
    }
}