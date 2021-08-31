package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    List<User> findTop1ByName(String name);
    List<User> findTop1ByNameOrderByIdDesc(String name);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);
    List<User> findFirstByName(String name, Sort sort);

    @Query(value="select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findRawRecord();
}
