package com.example.jpa_entity.domain.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class MyEntityListener {
    //해당 엔티티를 받아서 리스너에서 처리해야 해서,
    //전과 다르게 매개변수가 있어야!
    //단지, 그 인자값 타입이 무엇인지 알 수 없어서
    //Object 타입으로 강제
    @PrePersist
    public void prePersist(Object obj){
        if(obj instanceof Auditable){
            Auditable a=(Auditable) obj;
            a.setCreatedAt(LocalDateTime.now());
            a.setUpdatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object obj){
        if(obj instanceof Auditable){
            Auditable a=(Auditable) obj;
            a.setUpdatedAt(LocalDateTime.now());
        }
    }

}
