package com.example.yaml_setting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue
    private Integer idx;//인덱스
    @Column
    private String title;//제목
    @Column
    private LocalDateTime publishedAt;//출판일

    @Builder
    public Book(String title, LocalDateTime publishedAt){
        this.title=title;
        this.publishedAt=publishedAt;
    }

}
