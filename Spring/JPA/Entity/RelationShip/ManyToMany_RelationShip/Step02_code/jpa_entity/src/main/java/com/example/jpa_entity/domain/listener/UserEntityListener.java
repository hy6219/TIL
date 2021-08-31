package com.example.jpa_entity.domain.listener;

import com.example.jpa_entity.domain.User;
import com.example.jpa_entity.domain.UserHistory;
import com.example.jpa_entity.repository.UserHistoryRepository;
import com.example.jpa_entity.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class UserEntityListener {

    @PostPersist
    @PostUpdate
    public void prePersist(Object o){
        UserHistoryRepository userHistoryRepository= BeanUtils.getBean(UserHistoryRepository.class);
        User user=(User)o;
        //userHistory는 insert
        UserHistory userHistory=new UserHistory();
     //   userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setCratedAt(user.getCratedAt());
        userHistory.setUpdatedAt(user.getUpdatedAt());
        userHistory.setActive(user.isActive());
        userHistory.setGender(user.getGender());
        userHistory.setUser(user);

        userHistoryRepository.save(userHistory);
    }

}
