package com.example.interceptor.exceptionHandler;

import com.example.interceptor.exception.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value= AuthException.class)
    public ResponseEntity authException(){
        //build: body없이 리턴하기
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();//no body
    }
}
