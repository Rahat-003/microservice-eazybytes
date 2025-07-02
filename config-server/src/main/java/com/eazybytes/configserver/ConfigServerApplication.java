package com.eazybytes.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		System.out.println("--------- Hello World from config server ----------");
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
