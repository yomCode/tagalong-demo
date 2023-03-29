package com.demo.tagalong.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
public class RequestDto {

    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email cannot be empty")
    @NotNull(message = "Email is required")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @NotNull(message = "Password is required")
    @Size(min = 4, max = 6, message = "Password must be with 4 and 6 characters")
    private String password;
}
