package com.example.yaml_setting.service;

import com.example.yaml_setting.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getBookList();
}
