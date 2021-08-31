package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
