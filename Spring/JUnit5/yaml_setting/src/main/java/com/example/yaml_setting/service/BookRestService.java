package com.example.yaml_setting.service;

import com.example.yaml_setting.domain.Book;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class BookRestService {

    private final RestTemplate restTemplate;

    public BookRestService(RestTemplateBuilder builder){
        this.restTemplate=builder.rootUri("/rest/test").build();
    }

    public Book getRestBook(){

        return restTemplate.getForObject("/rest/test",Book.class);
    }
}