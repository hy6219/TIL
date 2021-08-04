package com.example.client.service;

import com.example.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class RestTemplateService {

    //http://localhost:9090/api/server/hello에 요청을 해서
    //응답을 받아올 것
    public UserResponse hello(String name, int age){
        //uri 만들기
        URI uri=
                UriComponentsBuilder
                        .fromUriString("http://localhost:9090")
                        .path("/api/server/hello")
                        .query("name="+name+"&age="+age)
                        .encode()
                        .build()
                        .toUri();

        log.info("uri: {}",uri);

        //RestTemplate만들기
        RestTemplate restTemplate= new RestTemplate();
        //restTemplate은 get,put,post,delete 등
        //요청 메서드를 모두 지원하는데
        //getForEntity은 ResponseEntity형태로 내려주어야 하지만
        //getForObject는 우리가 지정한 타입으로 응답을 내려줄 수 있다
        //getForObject가 실행되는 순간이 클라이언트에서 http로 서버에 접근하게 됨
     //01.   String res = restTemplate.getForObject(uri,String.class);
    // 02.   ResponseEntity<String> res= restTemplate.getForEntity(uri,String.class);
        //03.getForEntity-json
        ResponseEntity<UserResponse> res=restTemplate.getForEntity(uri,UserResponse.class);
        //03. getForObject-json
        //UserResponse res=restTemplate.getForObject(uri,UserResponse.class);
        HttpHeaders headers= res.getHeaders();
        log.info("RestTemplate uri: {}",res);
        log.info("RestTemplate getForEntity:status code-{}\n header:{}\nbody:{}",res.getStatusCode(),headers,res.getBody());
        log.info("header info:content-type-{}\n " +
                        "content-length-{}\n" +
                        "Date-{}\n" +
                        "Keep-Alive-{}\n" +
                        "Connection-{}",headers.get("Content-type"),
                headers.get("Content-Length"),
                headers.get("Date"),
                headers.get("Keep-Alive"),
                headers.get("Connection"));
        //
        return res.getBody();
    }
}
