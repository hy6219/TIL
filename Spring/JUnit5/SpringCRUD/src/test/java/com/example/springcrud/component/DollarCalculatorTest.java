package com.example.springcrud.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
//통합테스트
@SpringBootTest
//필요한 협력객체 주입
//@Import({MarketApi.class,Calculator.class})
public class DollarCalculatorTest {

    @MockBean
    private MarketApi marketApi;//스프링에서 빈으로 등록된 객체를 mocking처리

    @Autowired
    private Calculator calculator;//DollarCalculator 주입

    @Test
    public void dollarCalculatorTest(){
        Mockito.when(marketApi.connect()).thenReturn(3000);

        int sum=calculator.sum(10,10);
        int minus=calculator.minus(10,10);

        Assertions.assertEquals(60000,sum);
        Assertions.assertEquals(0,minus);
    }

}
