package com.fastcampus.programming.dmaker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DmakerApplication {

	public static void main(String[] args) {
		System.out.println("Hello");
		SpringApplication.run(DmakerApplication.class, args);
	}

}
