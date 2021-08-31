package com.example.jpa_entity.domain;

import com.example.jpa_entity.domain.listener.UserEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @NonNull
    @Column(name="name")
    private String name;
    @NonNull
    @Column(name="email")
    private String email;

    @Column(name="active")
    private boolean active;

    @Transient
    private String testData;

    //enum
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",insertable = false,updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories=new ArrayList<>();

    @OneToMany
    @JoinColumn(name="user_id")
    @ToString.Exclude
    private List<Review> reviews=new ArrayList<>();
}
