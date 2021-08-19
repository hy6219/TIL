package com.example.yaml_setting.repository;

import com.example.yaml_setting.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
