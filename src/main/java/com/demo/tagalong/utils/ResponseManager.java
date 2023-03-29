package com.demo.tagalong.utils;

import com.demo.tagalong.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseManager {

    public ApiResponse requestSuccessful(HttpStatus status, Object data){
        return new ApiResponse(data, true, status);
    }


    public ApiResponse requestFailed(HttpStatus status, Object data){
        return new ApiResponse(data, false, status);
    }
}
