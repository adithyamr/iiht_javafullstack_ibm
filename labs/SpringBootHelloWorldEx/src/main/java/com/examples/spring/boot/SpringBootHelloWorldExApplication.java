package com.examples.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootHelloWorldExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldExApplication.class, args);
	}
	
	@RequestMapping("/")
	public String sayHello() {
		return "Hello World from Spring Boot";
	}

}
