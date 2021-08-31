package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Gender;
import com.example.jpa_entity.domain.User;
import com.example.jpa_entity.domain.UserHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.jpa_entity.domain.Gender.MALE;
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

    @Test
    public void manyToOne(){
        User user=new User();
        user.setName("David");
        user.setEmail("david@fastcampus.com");
        user.setGender(MALE);

        userRepository.save(user);
        user.setName("daniel");
        userRepository.save(user);//update
        user.setEmail("davidToDaniel@fastcampus.com");
        userRepository.save(user);//update

        userHistoryRepository.findAll().forEach(System.out::println);

        List<UserHistory> list=userRepository.findByEmail("davidToDaniel@fastcampus.com").getUserHistories();
        System.out.println(list);

        System.out.println("양방향: "+userHistoryRepository.findById(1L).orElseThrow(RuntimeException::new).getUser());
    }
}