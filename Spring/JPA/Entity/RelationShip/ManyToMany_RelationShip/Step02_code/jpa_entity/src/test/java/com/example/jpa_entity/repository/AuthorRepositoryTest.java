package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Author;
import com.example.jpa_entity.domain.Book;
import com.example.jpa_entity.domain.BookAndAuthor;
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

    @Autowired
    private BookAndAuthorRepository bookAndAuthorRepository;

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

    private BookAndAuthor givenBookAndAuthor(Book book, Author author){
        BookAndAuthor ba=new BookAndAuthor();
        ba.setBook(book);
        ba.setAuthor(author);

        return bookAndAuthorRepository.save(ba);
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

        //중간테이블 엔티티
        BookAndAuthor ba1=givenBookAndAuthor(book1,author1);
        BookAndAuthor ba2=givenBookAndAuthor(book2,author2);
        BookAndAuthor ba3=givenBookAndAuthor(book3,author1);
        BookAndAuthor ba4=givenBookAndAuthor(book3,author2);
        BookAndAuthor ba5=givenBookAndAuthor(book4,author1);
        BookAndAuthor ba6=givenBookAndAuthor(book4,author2);

        book1.addBookAndAuthor(ba1);
        book2.addBookAndAuthor(ba2);
        book3.addBookAndAuthor(ba3,ba4);
        book4.addBookAndAuthor(ba5,ba6);

        author1.addBookAndAuthor(ba1,ba3,ba5);
        author2.addBookAndAuthor(ba2,ba4,ba6);
//        book1.setBookAndAuthors(Lists.newArrayList(ba1));
//        book2.setBookAndAuthors(Lists.newArrayList(ba2));
//        book3.setBookAndAuthors(Lists.newArrayList(ba3,ba4));
//        book4.setBookAndAuthors(Lists.newArrayList(ba5,ba6));
//
//        author1.setBookAndAuthors(Lists.newArrayList(ba1,ba3,ba5));
//        author2.setBookAndAuthors(Lists.newArrayList(ba2,ba4,ba6));

        bookRepository.saveAll(Lists.newArrayList(book1,book2,book3,book4));
        authorRepository.saveAll(Lists.newArrayList(author1,author2));

        System.out.printf("get book and author info from book table--\n");
        bookRepository.findAll().get(2).getBookAndAuthors().forEach(item->{
            System.out.printf("book: %s, author: %s\n",item.getBook(),item.getAuthor());
        });

        System.out.printf("get book and author info from author table--\n");
        authorRepository.findAll().get(0).getBookAndAuthors().forEach(item->{
            System.out.printf("book: %s, author: %s\n",item.getBook(),item.getAuthor());
        });


        //연관관계 넣어주기
//        book1.addAuthor(author1);
//        book2.addAuthor(author2);
//        book3.addAuthor(author1,author2);
//        book4.addAuthor(author1,author2);
//
//        author1.addBook(book1,book3,book4);
//        author2.addBook(book2,book3,book4);




       // System.out.println("authors through book: "+bookRepository.findAll().get(2).getAuthors());
     //   System.out.println("books through author: "+authorRepository.findAll().get(0).getBooks());

        /*
        * 주문 테이블에서는 User와 Product가 M:N관계가 될 수 있을것
        * ->따라서 User,Product 테이블 외에도
        * 중간 테이블로써 user_products가 ddl에서 보이게 될 것
        * 그런데 이 중간 테이블을 또다른 엔티티인 "order테이블"로써
        * 따로 엔티티를 만들어줄 수도 있을 것
        * */

    }

}