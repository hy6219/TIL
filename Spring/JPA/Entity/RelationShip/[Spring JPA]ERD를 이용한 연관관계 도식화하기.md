# 연관관계 개요 및 ERD 알아보기

## 01. What is ERD?

Entity Relationship Diagram = E-R Diagram

객체와 객체 사이의 연결성이 바로 관계인데, 객체와 관계로 데이터베이스 구조를 시각화해서 보여주는 다이어그램을 말한다

## 02. 관계가 없다면?

각 테이블마다 중복해서 레코드를 삽입해주어야 한다

(Book에도 User에도 겹쳐지는 부분을 넣어주어야 함)

→ 참조키만 사용하도록 관계를 설정해주면 보다 용이!

## 03. ERD, 관계

보통 일반적으로 의존성은 단방향으로 참조하지만,  엔티티는 양방향으로 참조하기도 한다!

draw.io를 사용해서 간단하게 저번 시간까지 진행되었던 데이터베이스 구조를 그려보자

앞으로는 이전에 이용했던 Book, User,UserHistory 뿐 아니라, 현실적으로 필요한 출판사 Publisher와 저자 Author 엔티티까지 생각해볼 것이다

![https://github.com/hy6219/TIL/blob/main/Spring/JPA/Entity/RelationShip/User.png?raw=true](https://github.com/hy6219/TIL/blob/main/Spring/JPA/Entity/RelationShip/User.png?raw=true)

- User-UserHistory

-한 명의 User에 대해서 insert, update 시 UserHistory에서는 여러 데이터가 저장됨

따라서 User:UserHistory=1:N 관계(N쪽은 1개 이상)

- User-Review

-한 명의 User가 1개 이상을 작성할 수 있어서 1:N 관계

- Book-Author

-한 명의 작가는 1개 이상의 책을 작성할 수도 있고, 1개의 책은 여러 작가에 의해 작성될 수 있어서

Book: Author=N : N

- Book-Publisher

-이 경우는 여러 케이스가 있어서 Book:Publisher=N:1 관계로 가정해두고 수정하기로 한다

- Book-Review

-한 개의 책에 대해서 여러 개의 리뷰가 존재할수도, 1개도 없을 수도 있어서 Book:Review=1:N(하지만 존재하지 않을 수 있어서 동그라미로 명시)

앞으로는 이를 이용해서 연관관계를 학습해보고, 도중에 엔티티의 컬럼 속성들도 변경해보자