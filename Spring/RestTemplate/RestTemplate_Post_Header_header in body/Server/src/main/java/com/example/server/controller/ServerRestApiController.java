package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    @PostMapping("/userId/{userId}/name/{name}")
//    public User hello(@RequestBody User user,
//                      @PathVariable long userId,
//                      @PathVariable String name,
//                      @RequestHeader(name="x-authorization") String xAuth,
//                      @RequestHeader(name="custom-header") String custom){
//        log.info("request user : {}",user);
//        log.info("x-authorization header: {}",xAuth);
//        log.info("custom header: {}",custom);
//        return user;
//    }
    @PostMapping("/userId/{userId}/name/{name}")
    public Req<User> hello(
                 @RequestBody Req<User> user,
                  @PathVariable long userId,
                  @PathVariable String name,
                  @RequestHeader(name="x-authorization") String xAuth,
                  @RequestHeader(name="custom-header") String custom){
            log.info("request user : {}",user);
            log.info("x-authorization header: {}",xAuth);
            log.info("custom header: {}",custom);

            Req<User> response=
                    new Req<>();

            Req.Header header =new Req.Header();
            User body=user.getBody();


            if(body==null){
                header.setResponseCode("400");
            }else{
                header.setResponseCode("200");
            }

            response.setHeader(
                   header
            );

            response.setBody(
                    body
            );

            log.info("response will be.. : {}",response);
            return response;
}

}
