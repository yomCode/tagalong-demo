package com.demo.tagalong.services;

import com.demo.tagalong.dto.ApiResponse;
import com.demo.tagalong.dto.RequestDto;

import java.util.Map;

public interface DataService {
    ApiResponse createData(RequestDto request);

    ApiResponse getData(String email, String password);
}
