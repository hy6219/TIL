package com.example.jpa_repository_interface;

import com.example.jpa_repository_interface.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class JpaRepositoryInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaRepositoryInterfaceApplication.class, args);
    }

}
