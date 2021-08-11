package com.example.jpa_repository_interface.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="user")
public class User {
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
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;
}
