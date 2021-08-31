package com.example.jpa_entity.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
//@EntityListeners(value={MyEntityListener.class})
//@EntityListeners(value={AuditingEntityListener.class})
public class UserHistory extends BaseEntity/*implements Auditable*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name="user_id",insertable = false,updatable = false)
//    private Long userId;

    private String name;

    private String email;

//    @CreatedDate
//    private LocalDateTime createdAt;
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    private boolean active;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private User user;
}
