package com.etna.gpe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class GpeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpeBackendApplication.class, args);
	}

}
