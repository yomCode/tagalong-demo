package com.demo.tagalong.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RequestDto {

    private String email;
    private String password;
}
