package com.example.yaml_setting.service;

import com.example.yaml_setting.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.HttpServerErrorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RestClientTest(BookRestService.class)
class BookRestServiceTest {

    @Autowired
    private BookRestService bookRestService;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void restTest(){
        server.expect(
                MockRestRequestMatchers.requestTo("/rest/test")
        ).andRespond(
                MockRestResponseCreators.withSuccess(new ClassPathResource("/test.json",getClass()), MediaType.APPLICATION_JSON)
        );

        Book book = this.bookRestService.getRestBook();
        assertThat(book.getTitle()).isEqualTo("테스트");
    }

    @Test
    public void restErrorTest(){
        server.expect(
                MockRestRequestMatchers.requestTo("/rest/test")
        ).andRespond(
                MockRestResponseCreators.withServerError()
        );

        assertThrows(HttpServerErrorException.class,()->{
            bookRestService.getRestBook();
        });
    }

}