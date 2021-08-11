package com.fastcampus.jpa.jpa_setting.repository;

import com.fastcampus.jpa.jpa_setting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository<User,Long> {
}
