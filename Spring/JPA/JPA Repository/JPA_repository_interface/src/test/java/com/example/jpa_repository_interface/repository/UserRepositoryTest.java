package com.example.jpa_repository_interface.repository;

import com.example.jpa_repository_interface.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void crud(){
      //  userRepository.save(new User());
    //    System.out.println(userRepository.findAll());
        userRepository.findAll().forEach(item->{
            System.out.println(item);
        });
    }

//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
}