package com.examples.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloWorld {

	public static void main(String[] args) {
		//Greetings greetings = new Greetings();
		//System.out.println(greetings.getMessage());
		
		//STEP 1: Create IoC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
		
		
		//STEP 2: Access Greetings Bean
		Greetings greetings = (Greetings) context.getBean("greetings");
		
		//STEP 3: Print the message
		System.out.println(greetings.getMessage());
		
		Greetings greetings1 = (Greetings) context.getBean("greetings1");
		System.out.println(greetings1.getMessage());
		
		System.out.println(context.getBeanDefinitionCount());
	}

}
