package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Book;
import com.example.jpa_entity.domain.BookReviewInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookReviewInfoRepositoryTest {

    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void test(){
        Book book=givenBook();
        BookReviewInfo info=new BookReviewInfo();

        info.setBook(book);
        info.setAverageReviewScore(3f);
        info.setReviewCount(5);

        bookReviewInfoRepository.save(info);
        bookReviewInfoRepository.findAll().forEach(System.out::println);
    }


    public Book givenBook(){
        Book book= new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        Book book1=bookRepository.save(book);
        return book1;
    }


    public void givenBookReview(Book book){
        BookReviewInfo info=new BookReviewInfo();
        info.setBook(book);
        info.setAverageReviewScore(4.5f);
        info.setReviewCount(2);

        bookReviewInfoRepository.save(info);

    }

    @Test
    public void relationTest(){
        Book book=givenBook();
        givenBookReview(book);

        bookRepository.findAll().forEach(System.out::println);
        bookReviewInfoRepository.findAll().forEach(System.out::println);

        Book book1=bookReviewInfoRepository.findById(1L).orElseThrow(RuntimeException::new).getBook();
        System.out.println(book1);

        BookReviewInfo info=bookRepository.findById(1L).orElseThrow(RuntimeException::new).getBookReviewInfo();
        System.out.println(info);
    }


}