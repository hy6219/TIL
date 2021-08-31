package com.example.jpa_entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaEntityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEntityApplication.class, args);
    }

}
