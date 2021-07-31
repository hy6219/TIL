package com.review_ioc.ioc.dto;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

//0.객체로 관리해주기를 부탁(IoC컨테이너)
@Component
public class UrlEncoder implements IEncoder{
    @Override
    public String encode(String msg) {
        try {
            return URLEncoder.encode(msg,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
