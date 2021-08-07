package com.example.springcrud.controller;

import com.example.springcrud.component.Calculator;
import com.example.springcrud.component.DollarCalculator;
import com.example.springcrud.component.ICalculator;
import com.example.springcrud.component.MarketApi;
import com.example.springcrud.dto.Req;
import com.example.springcrud.dto.Res;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//웹에 필요한 것들만 로딩시킴
@WebMvcTest(CalculatorApiController.class)
@AutoConfigureWebMvc
//calculator 주입
//calculator클래스에서는 ICalculator를 주입
@Import({DollarCalculator.class, Calculator.class})
public class CalculatorApiControllerTest {
    //MarketApi Mocking처리
    @MockBean
    private MarketApi marketApi;

    //mvc를 mocking으로 테스트
    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    public void init(){
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void sumTest() throws Exception {
        //http://localhost:8089/api/sum?x=~&y=~
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8089/api/sum")
                .queryParam("x","10")
                .queryParam("y","10")
        ).andExpect(
                //기대
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.content().string("60000")
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }

    @Test
    public void minusTest() throws Exception {
        Req request = new Req();

        request.setX(30);
        request.setY(10);

        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8089/api/minus")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().is2xxSuccessful()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.result")
                .value("60000")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.response.resultCode")
                .value("OK")
        ).andDo(
                MockMvcResultHandlers.print()
        );

    }

}
