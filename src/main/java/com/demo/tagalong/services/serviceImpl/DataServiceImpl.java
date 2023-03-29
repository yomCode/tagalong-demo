package com.demo.tagalong.services.serviceImpl;

import com.demo.tagalong.dto.ApiResponse;
import com.demo.tagalong.dto.RequestDto;
import com.demo.tagalong.services.DataService;
import com.demo.tagalong.utils.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private ResponseManager responseManager;

    @Override
    public ApiResponse createData(RequestDto request){

        return responseManager.requestSuccessful(HttpStatus.CREATED, new HashMap<>());

    }


    @Override
    public ApiResponse getData(String email, String password){

        return responseManager.requestSuccessful(HttpStatus.FOUND, new HashMap<>());
    }

}
