package com.example.server.controller;

import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerRestApiController {

//    @GetMapping("/hello")
//    public User hello(@RequestParam String name, @RequestParam int age){
//        User user =new User();
//        user.setName(name);
//        user.setAge(age);
//        log.info("request user : {}",user);
//        return user;
//    }
    @PostMapping("/userId/{userId}/name/{name}")
    public User hello(@RequestBody User user,@PathVariable long userId, @PathVariable String name){
        log.info("request user : {}",user);
        return user;
    }

}
