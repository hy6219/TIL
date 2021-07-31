package com.review_aop.aop.controller;

import com.review_aop.aop.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable long id,@RequestParam String name){
        System.out.println("get method: "+id+" "+name);
        StringBuilder sb = new StringBuilder();
        sb.append("id: "+id).append(", name: "+name);

        return sb.toString();
    }

    @PostMapping("/post")
    public ResponseEntity post(@RequestBody User user){
        System.out.println("post method :"+user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    //1.로그를 관리하는 aop를 만들어서 모든 메서드에 일괄적용
}
