package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Author;
import com.example.jpa_entity.domain.Book;
import com.example.jpa_entity.domain.BookAndAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAndAuthorRepository extends JpaRepository<BookAndAuthor,Long> {
}
