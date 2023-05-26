package com.example.InsuranceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan
@SpringBootApplication
public class InsuranceAppApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InsuranceAppApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(InsuranceAppApplication.class, args);
	}

}
