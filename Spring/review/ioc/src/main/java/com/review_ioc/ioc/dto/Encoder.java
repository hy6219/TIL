package com.review_ioc.ioc.dto;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//3.인코더도 객체로 등록하기
//@Component
public class Encoder {
    private IEncoder iEncoder;

    //3.Could not autowire. There is more than one bean of 'IEncoder' type.
    //연결된 빈이 두개라서 결정할 수 없기 때문에
    //autowired를 사용할 수 없어서
    //@Qualifier("사용할 빈 객체")를 넣어주면 됨
    public Encoder(/*@Qualifier("urlEncoder")*/ IEncoder iEncoder){
        this.iEncoder=iEncoder;
    }

    //2.setter 추가를 통한 객체 주입
    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder=iEncoder;
    }

    public String encode(String msg){
        return iEncoder.encode(msg);
    }
}
