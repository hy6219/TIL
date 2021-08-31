package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Long> {

}
