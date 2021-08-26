package com.example.jpa_entity.domain;

import com.example.jpa_entity.domain.listener.Auditable;
import com.example.jpa_entity.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
@Table(name="user")
//@EntityListeners(value={MyEntityListener.class,UserEntityListener.class})
//@EntityListeners(value={AuditingEntityListener.class, UserEntityListener.class})
@EntityListeners(value={UserEntityListener.class})
public class User extends BaseEntity /*implements Auditable*/{
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @NonNull
    @Column(name="name")
    private String name;
    @NonNull
    @Column(name="email")
    private String email;
//    @Column(name="created_at")
//    @CreatedDate
//    private LocalDateTime createdAt;
//    @Column(name="updated_at")
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    //IsNotEmpty 확인용
    //@OneToMany(fetch=FetchType.EAGER)
    //private List<Address> addresses;

    @Column(name="active")
    private boolean active;

    @Transient
    private String testData;

    //enum
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
