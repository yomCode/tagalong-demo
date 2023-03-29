package com.demo.tagalong.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {

    private Object data;
    private Boolean success;
    private HttpStatus status;
}
