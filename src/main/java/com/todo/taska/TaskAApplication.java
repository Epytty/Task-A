package com.todo.taska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TaskAApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskAApplication.class, args);
	}
}

