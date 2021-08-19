package com.example.yaml_setting;

import com.example.yaml_setting.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@JsonTest
public class BookJsonTest {

    @Autowired
    private JacksonTester<Book> json;

    @Test
    public void jsonTest() throws IOException {
        Book book= Book.builder().title("테스트").build();//인자가 2개거나 없거나 해야할텐데 그래서 에러날것(cuz 생성자)

        String content="{\"title\":\"테스트\"}";

        assertThat(this.json.parseObject(content).getTitle()).isEqualTo(book.getTitle());
        assertThat(this.json.parseObject(content).getPublishedAt()).isNull();

        //각 필드를 변환한 문자열이 test.json파일에 정의한 내용과 일치하는지 테스트
        assertThat(this.json.write(book)).isEqualTo("/test.json");
        //title값이 있는지 확인
        assertThat(this.json.write(book)).hasJsonPathStringValue("title");
        //title값이 일치하는지 확인
        assertThat(this.json.write(book)).extractingJsonPathStringValue("title").isEqualTo("테스트");

    }
}
