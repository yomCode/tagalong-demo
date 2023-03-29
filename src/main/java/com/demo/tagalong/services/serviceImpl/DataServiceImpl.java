package com.demo.tagalong.services.serviceImpl;

import com.demo.tagalong.dto.ApiResponse;
import com.demo.tagalong.dto.RequestDto;
import com.demo.tagalong.exceptions.FailedToCreateDataException;
import com.demo.tagalong.exceptions.NoDataFoundException;
import com.demo.tagalong.services.DataService;
import com.demo.tagalong.utils.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private ResponseManager responseManager;

    @Override
    public ApiResponse createData(RequestDto request){

        try {
            return responseManager.requestSuccessful(HttpStatus.CREATED, new HashMap<>());
        } catch (RuntimeException ex) {
          throw new FailedToCreateDataException("An errored while trying to create data \n Please try again later.");
        }
    }


    @Override
    public ApiResponse getData(String email, String password){

        try {
            return responseManager.requestSuccessful(HttpStatus.FOUND, new HashMap<>());
        } catch (RuntimeException ex) {
            throw new NoDataFoundException("Invalid data credentials");
        }
    }

}
