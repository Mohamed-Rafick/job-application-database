package com.employmentApp.jobSeekerModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class JobSeekerModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobSeekerModuleApplication.class, args);
	}

}
