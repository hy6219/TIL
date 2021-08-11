package com.fastcampus.jpa.jpa_setting.repository;

import com.fastcampus.jpa.jpa_setting.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        userRepository.save(new User());
        System.out.println(userRepository.findAll());
    }

}