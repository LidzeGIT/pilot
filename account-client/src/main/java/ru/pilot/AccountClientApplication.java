package ru.pilot;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Account",
				version = "1.0",
				description = ""
		)
)
public class AccountClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountClientApplication.class, args);
	}
}

