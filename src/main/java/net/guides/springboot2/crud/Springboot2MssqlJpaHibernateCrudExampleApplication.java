package net.guides.springboot2.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Springboot2MssqlJpaHibernateCrudExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2MssqlJpaHibernateCrudExampleApplication.class, args);
	}

}
