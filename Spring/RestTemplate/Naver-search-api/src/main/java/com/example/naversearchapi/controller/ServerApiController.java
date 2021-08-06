package com.example.naversearchapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api")
@Slf4j
public class ServerApiController {

    @GetMapping("/naver")
    public String naver(@RequestParam String search) throws UnsupportedEncodingException {
        //https://openapi.naver.com/v1/search/local.json?query=%EB%96%A1%EB%B3%B6%EC%9D%B4&display=5&sort=comment
        //로 요청을 보낼 것
        URI uri= UriComponentsBuilder.fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query",search)
                .queryParam("display","5")
                .queryParam("sort","comment")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        RestTemplate restTemplate =new RestTemplate();

        log.info("uri: {}",uri);
        RequestEntity<Void> requestEntity=
                RequestEntity.get(uri)
                             .header("X-Naver-Client-ID","your client id")
                             .header("X-Naver-Client-Secret","your client secret")
                             .build();

        //헤더값을 채워서 넣기 위해서 exchange이용
        ResponseEntity<String> res = restTemplate.exchange(requestEntity,String.class);
        log.info("header: {}",res.getHeaders());
        return res.getBody();
    }

}
