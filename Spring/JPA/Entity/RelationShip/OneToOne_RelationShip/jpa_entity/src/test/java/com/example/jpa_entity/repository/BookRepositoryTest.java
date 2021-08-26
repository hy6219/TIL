package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;


    @BeforeEach
    public void init(){
        System.out.println("insert");
        Book book=new Book();
        book.setName("테스트");
        book.setAuthorId(1L);
        book.setPublisherId(1L);
        bookRepository.save(book);
        System.out.println("insert 끝");
    }

    @Test
    public void bookTest(){
        Book book=new Book();
        book.setName("jpa 초격차 패키지");
        book.setAuthorId(2L);
        book.setPublisherId(2L);

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
}