package com.example.filter.controller;

import com.example.filter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @PostMapping("/user")
    public User post(@RequestBody User user){
        log.info("User: {} [name: {}, age: {}]",user,user.getName(),user.getAge());
        return user;
    }

}
