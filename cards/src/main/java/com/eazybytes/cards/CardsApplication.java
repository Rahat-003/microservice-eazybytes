package com.eazybytes.cards;

import com.eazybytes.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(value = CardsContactInfoDto.class)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "EazyBank Cards microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Rahat",
						email = "rahatakhter4@gmail.com",
						url = "https://www.github.com/Rahat-003"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.github.com/Rahat-003"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Cards microservice REST API Documentation",
				url = "https://www.eazybytes.com/swagger-ui.html"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		System.out.println("------- Hello World from Cards microservice -------");
		SpringApplication.run(CardsApplication.class, args);
	}

}
