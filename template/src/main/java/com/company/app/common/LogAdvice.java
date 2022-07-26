package com.company.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Service
public class LogAdvice {
	
	@Pointcut("execution(* com.company.app..*Impl.*(..))")
	public void allpointcut() {}
	
	@Before("allpointcut()")
	public void printLog(JoinPoint jp) {
		String name = jp.getSignature().getName();
		String args = jp.getArgs() != null && jp.getArgs().length > 0 ? 
				jp.getArgs()[0].toString() : "";
		System.out.printf("[before] 로그 출력 name=%s args=%s", name, args);
	}
	
}
