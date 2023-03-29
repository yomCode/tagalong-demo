package com.demo.tagalong.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NoDataFoundException extends RuntimeException{

    public NoDataFoundException(String message) {
        super(message);
    }
}
