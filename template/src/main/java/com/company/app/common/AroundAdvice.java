package com.company.app.common;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Service
public class AroundAdvice {
	
	@Around("LogAdvice.allpointcut()")
	public Object logTime(ProceedingJoinPoint pjp) {
		// 서비스 실행 전
		long start = System.currentTimeMillis();
		// log.info("Target: " + pjp.getTarget());
		// log.info("Param: " + Arrays.toString(pjp.getArgs()));
		// AfterAdvice에서 사용할 return Object 선언
		Object result = null;
		try {
			// 서비스 호출
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// 서비스 실행 후
		long end = System.currentTimeMillis();
		log.info("TIME: " + (end - start));
		return result;
	}
	
}
