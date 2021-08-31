package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Author;
import com.example.jpa_entity.domain.Book;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    private Book givenBook(String name){
        Book book=new Book();
        book.setName(name);

        return bookRepository.save(book);
    }

    private Author givenAuthor(String name){
        Author author=new Author();

        author.setName(name);
        return authorRepository.save(author);
    }

    @Test
    @Transactional
    public void manyToManyTest(){
        Book book1=givenBook("책1");
        Book book2=givenBook("책2");
        Book book3=givenBook("개발책1");
        Book book4=givenBook("개발책2");

        Author author1=givenAuthor("martin");
        Author author2=givenAuthor("steve");

        //연관관계 넣어주기
        book1.addAuthor(author1);
        book2.addAuthor(author2);
        book3.addAuthor(author1,author2);
        book4.addAuthor(author1,author2);

        author1.addBook(book1,book3,book4);
        author2.addBook(book2,book3,book4);


        bookRepository.saveAll(Lists.newArrayList(book1,book2,book3,book4));
        authorRepository.saveAll(Lists.newArrayList(author1,author2));

        System.out.println("authors through book: "+bookRepository.findAll().get(2).getAuthors());
        System.out.println("books through author: "+authorRepository.findAll().get(0).getBooks());

        /*
        * 주문 테이블에서는 User와 Product가 M:N관계가 될 수 있을것
        * ->따라서 User,Product 테이블 외에도
        * 중간 테이블로써 user_products가 ddl에서 보이게 될 것
        * 그런데 이 중간 테이블을 또다른 엔티티인 "order테이블"로써
        * 따로 엔티티를 만들어줄 수도 있을 것
        * */

    }
}