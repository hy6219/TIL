package com.example.jpa_repository_interface.repository;

import com.example.jpa_repository_interface.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {

}
