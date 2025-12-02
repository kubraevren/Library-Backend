package com.kubraevren.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.kubraevren"})
@ComponentScan(basePackages = {"com.kubraevren"})
@EnableJpaRepositories(basePackages = {"com.kubraevren"})
@SpringBootApplication
public class LibraryApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplicationStarter.class, args);
	}

}
