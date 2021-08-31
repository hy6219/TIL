package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
