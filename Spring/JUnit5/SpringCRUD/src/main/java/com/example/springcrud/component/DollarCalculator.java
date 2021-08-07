package com.example.springcrud.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DollarCalculator implements ICalculator {

    private int price =1;
    //통신을 통해서 시세를 가져와서 적용하기 위함
    //그런데 계산기의 목적과 "통신"은 부적절하기 때문에 분리할것
    private final MarketApi marketApi;

//    public DollarCalculator(MarketApi marketApi){
//        this.marketApi=marketApi;
//    }
    @Override
    public void init(){
        this.price= marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x*=price;
        y*=price;
        return x+y;
    }

    @Override
    public int minus(int x, int y) {
        x*=price;
        y*=price;
        return x-y;
    }
}
