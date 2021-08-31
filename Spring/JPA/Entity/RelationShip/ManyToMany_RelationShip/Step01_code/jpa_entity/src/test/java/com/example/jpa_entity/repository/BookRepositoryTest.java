package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Book;
import com.example.jpa_entity.domain.Publisher;
import com.example.jpa_entity.domain.Review;
import com.example.jpa_entity.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void init(){
        System.out.println("insert");
        Book book=new Book();
        book.setName("테스트");
        book.setAuthorId(1L);
      //  book.setPublisherId(1L);
        bookRepository.save(book);
        System.out.println("insert 끝");
    }

    @Test
    public void bookTest(){
        Book book=new Book();
        book.setName("jpa 초격차 패키지");
        book.setAuthorId(2L);
      //  book.setPublisherId(2L);

        bookRepository.save(book);

        bookRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void listenerTest(){
        bookRepository.findAll().forEach(System.out::println);
//Book(id=6, name=테스트, author=테스트, createdAt=2021-08-24T15:10:22.153, updatedAt=2021-08-24T15:10:22.153)
        System.out.println("update");
        Book book2=bookRepository.findById(6L).orElseThrow(RuntimeException::new);
        book2.setName("수정");
        bookRepository.save(book2);
        System.out.println("update 끝");
        bookRepository.findAll().forEach(System.out::println);
    }



    private User givenUser(){
        return userRepository.findByEmail("martin@fastcampus.com");
    }

    private Publisher givenPublisher(){
        Publisher publisher=new Publisher();

        publisher.setName("테스트 publisher");
        publisherRepository.save(publisher);

        return publisher;
    }

    private Book givenBook(Publisher publisher) {
        Book book=new Book();
        book.setName("책입니당");
        book.setPublisher(publisher);

        bookRepository.save(book);

        return book;
    }

    private void givenReview(User user, Book book) {
        Review review= new Review();

        review.setTitle("테스트 인 부트");
        review.setContent("잼잼!");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    private void givenBookAndReview() {
        User user=givenUser();
        Publisher publisher=givenPublisher();
        Book book=givenBook(publisher);
        givenReview(user,book);
    }

    @Test
    @Transactional
    public void bookRelationTest(){
        //Book정보와 Review 정보를 저장
        givenBookAndReview();
        User user=userRepository.findByEmail("martin@fastcampus.com");
        System.out.println("User : (userRepository)-"+user);
        System.out.println("Review<-User: "+user.getReviews());
        System.out.println("Book<-Review<-User: "+user.getReviews().get(0).getBook());
        System.out.println("Publisher<-Book<-Review<-User: "+user.getReviews().get(0).getBook().getPublisher());
    }


}