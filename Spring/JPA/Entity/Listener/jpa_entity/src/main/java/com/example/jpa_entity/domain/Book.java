package com.example.jpa_entity.domain;

import com.example.jpa_entity.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
///@EntityListeners(value=MyEntityListener.class)
//@EntityListeners(value= AuditingEntityListener.class)
public class Book extends BaseEntity/* implements Auditable*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //책 이름
    private String name;
    //책 저자
    private String author;
    //생성일
//    @CreatedDate
//    private LocalDateTime createdAt;
//    //수정일
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

}
