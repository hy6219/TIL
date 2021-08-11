package com.fastcampus.jpa.jpa_setting.domain;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    //생성된 시간과 수정된 시간은 jpa 도메인에 항상 포함되도록 되어 있음
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//클래스이름위 커서+alt+shift : 테스트 생성

}
