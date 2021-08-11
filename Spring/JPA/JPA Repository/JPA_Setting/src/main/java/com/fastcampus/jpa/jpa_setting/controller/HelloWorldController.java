package com.fastcampus.jpa.jpa_setting.controller;

import com.fastcampus.jpa.jpa_setting.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloApi")
public class HelloWorldController {


    @GetMapping("/hello")
    public String helloWorld(){
        return "helloWorld";
    }

}
