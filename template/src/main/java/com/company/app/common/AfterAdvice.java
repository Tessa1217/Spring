package com.company.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Service
public class AfterAdvice {
	
	/*
	 * @Pointcut("execution(* com.company.app..*Impl.*(..))") public void
	 * allpointcut() {}
	 */
	
	@After("LogAdvice.allpointcut()")
	public void afterLog() {
		System.out.println("[after] 로그 출력");
	}
	
	@AfterReturning(pointcut = "LogAdvice.allpointcut()", returning = "returning")
	public void successLog(JoinPoint jp, Object returning) {
		System.out.printf("[return 값] returnVal=%s", returning);
				
	}
}
