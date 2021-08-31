package com.example.jpa_entity.repository;

import com.example.jpa_entity.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
