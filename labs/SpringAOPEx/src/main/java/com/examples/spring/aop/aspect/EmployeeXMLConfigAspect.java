package com.examples.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeXMLConfigAspect {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeXMLConfigAspect.class);

	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		
		//logger.info("PortfolioXMLConfigAspect:: inside employeeAroundAdvice() when invoking Genweb getName() method");
		System.out.println("AroundAdvise -> Going to setup employee profile");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("AroundAdvise -> Employee profile has been setup");
//		logger.info("PortfolioXMLConfigAspect:: value employeeAroundAdvice() when invoking Genweb getName() method" + value);
		return value;
	}
	
	public void beforeAdvice()
	{
		System.out.println("BeforeAdvice -> Going to setup employee profile");
//		logger.info("BeforeAdvice -> Going to setup employee profile");
	}
	
	public void afterAdvice()
	{
		System.out.println("AfterAdvice -> Employee profile has been setup");
//		logger.info("AfterAdvice -> Employee profile has been setup");
	}
	
	public void returningAdvice(String retVal)
	{
		System.out.println("ReturningAdvice -> " + retVal);
	}
	
	public void afterThrow(Exception ex)
	{
		System.out.println("AfterThrow -> Exception has been thrown. " + ex.getMessage());
	}
	
}
