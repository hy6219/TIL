package com.fastcampus.jpa.jpa_setting.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest {

    @Autowired
    private User user;

    @Test
    public void userTest(){
//        user.setName("steve");
//        user.setEmail("123");
        User myUser=User.builder().name("steve").email("123").build();
        System.out.println(myUser);//User(name=steve, email=123, createdAt=null, updatedAt=null)
    }

}
