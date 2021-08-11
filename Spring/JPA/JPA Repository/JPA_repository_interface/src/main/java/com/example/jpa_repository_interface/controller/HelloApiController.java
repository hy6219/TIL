package com.example.jpa_repository_interface.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class HelloApiController {

    @GetMapping("/hello")
    public String hello(){
        return "helloWorld!";
    }
}
