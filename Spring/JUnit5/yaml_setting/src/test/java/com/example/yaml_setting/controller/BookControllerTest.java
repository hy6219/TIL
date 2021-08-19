package com.example.yaml_setting.controller;

import com.example.yaml_setting.domain.Book;
import com.example.yaml_setting.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;

@WebMvcTest(BookController.class)//1
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;//2

    @MockBean
    private BookService bookService;//3

    @Test
    public void bookMvcTest() throws Exception {
        Book book=new Book("Spring Boot Book",LocalDateTime.now());


        //4.메서드 반환값을 미리 정의
        given(bookService.getBookList()).willReturn(Collections.singletonList(book));

        //5.실행, 예측과 실제를 비교
        mockMvc.perform(
                MockMvcRequestBuilders.get("/books")
        ).andExpect(
                MockMvcResultMatchers.status().is2xxSuccessful()
        ).andExpect(
                MockMvcResultMatchers.view().name("book")
        ).andExpect(
                MockMvcResultMatchers.model().attributeDoesNotExist("bookList")
        ).andExpect(
                MockMvcResultMatchers.model().attribute("bookList",contains(book))
        ).andDo(
                MockMvcResultHandlers.print()
        );

    }
}