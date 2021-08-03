package com.example.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//권한이 없는 사용자까지 모두 들어올 수 있도록 하기
@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/hello")
    public String hello(){
        return "public Hello";
    }

}
