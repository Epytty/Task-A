package com.todo.taska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories
public class TaskAApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskAApplication.class, args);
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Resource resource = new ClassPathResource("schema.sql");
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
		databasePopulator.execute(dataSource);

		return jdbcTemplate;
	}
	}

