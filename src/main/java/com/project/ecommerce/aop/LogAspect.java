//package com.project.ecommerce.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.project.ecommerce.ECommerceApplication;
//
//@Component
//@Aspect
//public class LogAspect {
//
//	private static Logger log = LoggerFactory.getLogger(ECommerceApplication.class);
//
//	@Pointcut(value = "execution(* com.project.ecommerce.controller.*.*(..))")
//	public void pointLog() {
//	}
//
//	@AfterReturning(returning = "result", value = "pointLog()")
//	public void after(JoinPoint jp) throws Throwable {
//		log.info("Se ejecuto con exito el metodo {}", jp.getSignature().getName());
//	}
//
//
//}
