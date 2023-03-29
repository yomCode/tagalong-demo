package com.demo.tagalong.controllers;


import com.demo.tagalong.dto.ApiResponse;
import com.demo.tagalong.dto.RequestDto;
import com.demo.tagalong.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/v1/data")
@Validated
public class DataController {

    @Autowired
    private DataService service;


    @PostMapping("/")
    public ApiResponse newData(@RequestBody @Valid RequestDto request){
        return service.createData(request);
    }


    @GetMapping("")
    public ApiResponse getData(@RequestParam(name="email", defaultValue = "")
                                   @Email(message = "Please provide a valid email")
                                   @NotBlank(message = "Email is required") String email,
                               @RequestParam(name = "password", defaultValue = "") @NotBlank(message = "Password is required") String password){
        return service.getData(email, password);
    }

}
