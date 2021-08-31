package com.example.jpa_entity.domain;

import com.example.jpa_entity.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class BookReviewInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;//boorReviewInfo 의 PK

    //private Long bookId;
    @OneToOne
    private Book book;

    //Wrapper class는 null을 허용할지 안할지가 중요한데
    //averageReviewScore나 reviewCount는 null도 포함시켜서
    //생각해볼 수 있기 때문에 small float, small int를 이용(null이 0이므로)

    private float averageReviewScore;

    private int reviewCount;

}
