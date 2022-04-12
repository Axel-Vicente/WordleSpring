package com.example.jueguito.jueguito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.jueguito.*")
@SpringBootApplication
public class JueguitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JueguitoApplication.class, args);
	}

}
