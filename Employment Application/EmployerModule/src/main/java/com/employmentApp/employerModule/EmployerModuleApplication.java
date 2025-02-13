package com.employmentApp.employerModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EmployerModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployerModuleApplication.class, args);
	}

}
