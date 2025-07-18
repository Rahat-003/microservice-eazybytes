package com.eazybytes.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		System.out.println("--------- Hello World from config server ----------");
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
