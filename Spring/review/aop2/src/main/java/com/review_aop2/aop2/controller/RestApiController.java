package com.review_aop2.aop2.controller;

import com.review_aop2.aop2.annotation.Decode;
import com.review_aop2.aop2.annotation.Timer;
import com.review_aop2.aop2.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable(name="id") long id, @RequestParam String name){
        StringBuilder sb= new StringBuilder();
        sb.append("id: "+id).append(", name: "+name);
        return sb.toString();
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        System.out.println("put: "+user);
        return user;
        //post: create, put: create &update
    }

}
