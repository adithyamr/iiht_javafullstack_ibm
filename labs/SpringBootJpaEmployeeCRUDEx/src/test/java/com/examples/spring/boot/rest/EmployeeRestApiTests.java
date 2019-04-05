package com.examples.spring.boot.rest;


import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRestApiTests {

	@Autowired
	ApplicationContext ctx;
	
	@Test
	public void contextLoads() {
		System.out.println(ctx.getBeanDefinitionCount());
		for(String bean: ctx.getBeanDefinitionNames())
		{
			System.out.println(bean);
		}
	}

}
