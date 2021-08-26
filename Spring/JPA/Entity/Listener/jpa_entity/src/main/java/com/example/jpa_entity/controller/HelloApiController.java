package com.example.jpa_entity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class HelloApiController {

    @GetMapping("/hello")
    public String hello(){
        return "helloWorld!";
    }
}
