package com.fastcampus.jpa.jpa_setting.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@WebMvcTest(HelloWorldController.class)
@AutoConfigureWebMvc
public class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        URI uri= UriComponentsBuilder.fromUriString("http://localhost:8089")
                .path("/helloApi/hello")
                .build()
                .toUri();

        ResultActions res = mockMvc.perform(
                MockMvcRequestBuilders.get(uri)
        ).andExpect(
                MockMvcResultMatchers.status().is2xxSuccessful()
        ).andExpect(
                MockMvcResultMatchers.content().string("helloWorld")
        ).andDo(
                MockMvcResultHandlers.print()
        );


    }

}
