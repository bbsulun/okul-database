package com.cmv.okuldatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OkulDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(OkulDatabaseApplication.class, args);
	}

}
