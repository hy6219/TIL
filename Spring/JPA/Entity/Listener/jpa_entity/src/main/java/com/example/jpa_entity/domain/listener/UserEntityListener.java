package com.example.jpa_entity.domain.listener;

import com.example.jpa_entity.domain.User;
import com.example.jpa_entity.domain.UserHistory;
import com.example.jpa_entity.repository.UserHistoryRepository;
import com.example.jpa_entity.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class UserEntityListener {

    @PrePersist
    @PreUpdate
    public void prePersist(Object o){
        UserHistoryRepository userHistoryRepository= BeanUtils.getBean(UserHistoryRepository.class);
        User user=(User)o;
        //userHistory는 insert
        UserHistory userHistory=new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setCratedAt(user.getCratedAt());
        userHistory.setUpdatedAt(user.getUpdatedAt());
        userHistory.setActive(user.isActive());
        userHistory.setGender(user.getGender());

        userHistoryRepository.save(userHistory);
    }

}
