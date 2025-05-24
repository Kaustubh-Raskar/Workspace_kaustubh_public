package com.kaustubh.rentvideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RentvideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentvideoApplication.class, args);
	}

}
