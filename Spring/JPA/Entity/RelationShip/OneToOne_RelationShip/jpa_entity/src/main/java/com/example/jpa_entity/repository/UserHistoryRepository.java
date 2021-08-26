package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserHistoryRepository extends JpaRepository<UserHistory,Long> {

}
