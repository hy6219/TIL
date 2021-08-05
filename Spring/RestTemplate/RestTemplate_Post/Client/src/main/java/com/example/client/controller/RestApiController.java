package com.example.client.controller;

import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class RestApiController {

    private final RestTemplateService restTemplateService;

//    @GetMapping("")
//    public UserResponse getHello(@RequestParam String name, @RequestParam int age){
//        return restTemplateService.hello(name,age);
//    }

    @PostMapping("/userId/{userId}/name/{name}")
    public UserResponse post(@RequestBody UserRequest user,@PathVariable long userId, @PathVariable  String name){
        return restTemplateService.post(user,userId,name);
    }
}
