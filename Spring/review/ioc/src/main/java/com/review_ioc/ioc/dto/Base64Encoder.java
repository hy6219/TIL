package com.review_ioc.ioc.dto;

import org.springframework.stereotype.Component;

import java.util.Base64;

//0.객체로 관리해주기를 부탁(IoC컨테이너)
@Component
public class Base64Encoder implements IEncoder{
    @Override
    public String encode(String msg) {
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
}
