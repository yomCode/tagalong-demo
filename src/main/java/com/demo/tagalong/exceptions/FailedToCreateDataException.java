package com.demo.tagalong.exceptions;


import com.demo.tagalong.dto.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FailedToCreateDataException extends RuntimeException{

    public FailedToCreateDataException(String message) {
        super(message);
    }
}
