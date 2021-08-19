package com.example.yaml_setting.repository;

import com.example.yaml_setting.domain.Book;
import org.assertj.core.util.Lists;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DataJpaTest
class BookRepositoryTest {

    private final static String BOOT_TEST_TITLE="Spring Boot Test Book";

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void bookSaveTest(){
        Book book= Book.builder().title(BOOT_TEST_TITLE).publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book);
        assertThat(bookRepository.getOne(book.getIdx()),is(book));
    }

    @Test
    public void bookSaveSearchTest(){
        Book book1= Book.builder().title(BOOT_TEST_TITLE+" 1").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book1);
        Book book2= Book.builder().title(BOOT_TEST_TITLE+" 2").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book2);
        Book book3= Book.builder().title(BOOT_TEST_TITLE+" 3").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book3);

        List<Book> bookList=bookRepository.findAll();
        assertThat(bookList,hasSize(3));
        assertThat(bookList,contains(book1,book2,book3));
    }

    @Test
    public void bookListSaveAndDelete(){
        Book book1= Book.builder().title(BOOT_TEST_TITLE+" 1").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book1);
        Book book2= Book.builder().title(BOOT_TEST_TITLE+" 2").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book2);


        bookRepository.deleteAllInBatch();
        assertThat(bookRepository.findAll(),IsEmptyCollection.empty());
    }

}