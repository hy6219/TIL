package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Gender;
import com.example.jpa_entity.domain.User;
import com.example.jpa_entity.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.jpa_entity.domain.Gender.FEMALE;
import static com.example.jpa_entity.domain.Gender.MALE;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    public void top(){
        System.out.println("findTop1ByName: "+userRepository.findTop1ByName("martin"));
        System.out.println("findTop1ByNameOrderByIdDesc: "+userRepository.findTop1ByNameOrderByIdDesc("martin"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc: "+userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));
        System.out.println("findFirstByName-desc id: "+userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"))));
        System.out.println("findFirstByName-asc id: "+userRepository.findFirstByName("martin", Sort.by(Sort.Order.asc("id"))));
        System.out.println("findFirstByName-by id: "+userRepository.findFirstByName("martin", Sort.by(Sort.Order.by("id"))));

        System.out.println("여러 정렬조건을 OrderBy없이- List<Order> :"+userRepository.findFirstByName("martin",Sort.by(Lists.newArrayList(Sort.Order.desc("id"),Sort.Order.by("email")))));
        System.out.println("여러 정렬조건을 OrderBy없이-가변인자 이용: "+userRepository.findFirstByName("martin",Sort.by(Sort.Order.desc("id"),Sort.Order.asc("email"))));
        System.out.println("Sort형 메서드를 만들어서 정렬해서 가독성 높이기: "+userRepository.findFirstByName("martin",getSort()));
    }

    private Sort getSort(){
        return Sort.by(
                Sort.Order.desc("id"),
                Sort.Order.asc("email").ignoreCase(),
                Sort.Order.desc("createdAt")
        );
    }

    @Test
    public void dmlAccess(){
        User user=new User();

        user.setName("martin");
        user.setEmail("martin2@fastcampus.com");

        userRepository.save(user);//insert

        User user2=userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setEmail("update_1l_id@fastcampus.com");

        userRepository.save(user2);//update

        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void enumTest(){
        User user=userRepository.findById(1L).orElseThrow(RuntimeException::new);

        user.setGender(MALE);
        userRepository.save(user);//update

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    @Test
    public void insertListener(){
        User user=new User("kate","myKate@slowcampus.com");
        userRepository.save(user);
    }

    @Test
    public void selectEvent(){
        User user=userRepository.findById(2L).orElseThrow(RuntimeException::new);
        System.out.println(user);
    }

    @Test
    public void updateEvent(){
        User user=userRepository.findById(3L).orElseThrow(RuntimeException::new);
        user.setGender(FEMALE);
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void deleteEvent(){
        userRepository.deleteAll();
        System.out.println("---");
        userRepository.deleteAllInBatch();
    }

    @Test
    public void prePersistTest(){
        User user= new User();
        user.setEmail("abc@fastcampus.com");
        user.setName("abc");
   //     user.prePersist();
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);//insert

        System.out.println(userRepository.findByEmail(user.getEmail()));
    }
//1:n 적용 전
    @Test
    public void userRelationTest(){
        User user=new User();
        user.setName("David");
        user.setEmail("david@fastcampus.com");
        user.setGender(MALE);

        userRepository.save(user);
        user.setName("daniel");
        userRepository.save(user);//update
        user.setEmail("davidToDaniel@fastcampus.com");
        userRepository.save(user);//update
        List<UserHistory> list=userHistoryRepository.findByUserId(
                userRepository.findByEmail("davidToDaniel@fastcampus.com").getId()
        );
        System.out.println(list);
    }
//1:n적용후
    @Test
    public void oneToManyTest(){
        User user=new User();
        user.setName("David");
        user.setEmail("david@fastcampus.com");
        user.setGender(MALE);

        userRepository.save(user);
        user.setName("daniel");
        userRepository.save(user);//update
        user.setEmail("davidToDaniel@fastcampus.com");
        userRepository.save(user);//update

        List<UserHistory> list=userRepository.findByEmail("davidToDaniel@fastcampus.com").getUserHistories();
        System.out.println(list);
    }


}