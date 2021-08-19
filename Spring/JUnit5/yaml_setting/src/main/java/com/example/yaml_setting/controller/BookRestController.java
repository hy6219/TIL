package com.example.yaml_setting.controller;

import com.example.yaml_setting.domain.Book;
import com.example.yaml_setting.service.BookRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

    @Autowired
    private BookRestService bookRestService;

    @GetMapping(value="/rest/test", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Book getRestBooks(){
        return bookRestService.getRestBook();
    }
}
