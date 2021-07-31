package com.review_aop2.aop2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Base64;

@SpringBootApplication
public class Aop2Application {

    public static void main(String[] args) {
        SpringApplication.run(Aop2Application.class, args);
        System.out.println(Base64.getEncoder().encodeToString("steve@gmail.com".getBytes()));
        /*
        * req:
        * {
  "id":"김길동",
  "pw":"1234",
  "email":"c3RldmVAZ21haWwuY29t"
}
*
* response:
*
* {
"id": "김길동",
"pw": "1234",
"email": "c3RldmVAZ21haWwuY29t"
}
        * */
    }

}
