package com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RepositoriesServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RepositoriesServiceApplication.class, args);
	}
}
