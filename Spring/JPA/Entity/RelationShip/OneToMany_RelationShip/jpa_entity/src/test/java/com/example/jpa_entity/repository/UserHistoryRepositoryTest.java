package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Gender;
import com.example.jpa_entity.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserHistoryRepositoryTest {

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void prePersistAndUpdateListenerTest(){
        User user=new User();
        user.setEmail("abcd@fastcampus.com");
        user.setName("abcd");
        user.setGender(Gender.MALE);

        userRepository.save(user);
        System.out.println("---insert완료");

        user.setName("abcde");
        userRepository.save(user);
        System.out.println("---update완료");

        userHistoryRepository.findAll().forEach(System.out::println);
    }

}