package com.spring.boot.configurations;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * aop面向切面日志等处理
 * @author wang_donggang
 */
@Aspect
@Component
public class HttpAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(* com.spring.boot.*.controllers.*.*(..))")
	public void log() {
		
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		logger.info("url={}", request.getRequestURL());
		logger.info("ip={}", request.getRemoteAddr());
		logger.info("method={}", request.getMethod());
		logger.info("class_name={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("args={}", joinPoint.getArgs());
	}
	
	@After("log()")
	public void doAfter() {
		logger.info("2222222222222222");
	}
	
	@AfterReturning(returning = "object", pointcut="log()")
	public void doAfterReturning(Object object) {
		logger.info("response={}", object);
	}
	
}
