package com.demo.tagalong.controllers;


import com.demo.tagalong.dto.ApiResponse;
import com.demo.tagalong.dto.RequestDto;
import com.demo.tagalong.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/data")
public class DataController {

    @Autowired
    private DataService service;


    @PostMapping("/")
    public ApiResponse newData(@RequestBody RequestDto request){
        return service.createData(request);
    }


    @GetMapping("/")
    public ApiResponse getData(@RequestParam(name="email") String email,
                               @RequestParam(name = "password") String password){

        return service.getData(email, password);
    }

}
