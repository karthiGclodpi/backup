package com.tst.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class firstAsp {

	@Before("execution(* com.rest.doorstep.services.*.*(..))")
	public void asp()
	{
		System.out.println("im called");
	}
}
