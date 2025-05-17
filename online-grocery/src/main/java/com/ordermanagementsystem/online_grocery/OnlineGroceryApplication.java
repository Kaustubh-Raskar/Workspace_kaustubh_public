package com.ordermanagementsystem.online_grocery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OnlineGroceryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineGroceryApplication.class, args);
	}

}
