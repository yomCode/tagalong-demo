package com.demo.tagalong.exceptions;

import com.demo.tagalong.dto.ApiResponse;
import com.demo.tagalong.utils.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ResponseManager responseManager;

    @ExceptionHandler(NoDataFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleNoDataFoundException(NoDataFoundException ex){
        String message = ex.getMessage();
        return responseManager.requestFailed(HttpStatus.BAD_REQUEST, message);
    }


    @ExceptionHandler(FailedToCreateDataException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse handleFailedToCreateDataException(FailedToCreateDataException ex){
        String message = ex.getMessage();
        return responseManager.requestFailed(HttpStatus.NOT_FOUND, message);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse invalidDataAttributes(MethodArgumentNotValidException ex) {

        String message = Objects.requireNonNull(ex.getFieldError()).getDefaultMessage();
        return responseManager.requestFailed(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse invalidDataParameters(ConstraintViolationException ex) {

        String message = ex.getMessage();
        return responseManager.requestFailed(HttpStatus.BAD_REQUEST, message);
    }
}
