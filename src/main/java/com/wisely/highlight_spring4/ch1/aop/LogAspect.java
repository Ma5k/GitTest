package com.wisely.highlight_spring4.ch1.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 1、通过@Aspect注解声明一个切面
 * 2、通过@Component让此切面成为一个Spring容器管理的Bean
 * 3、通过@PointCut注解声明切点
 * 4、通过@After注解声明一个建言，并使用@PointCut定义的切点
 * 5、通过反射可获得注解上的属性，然后做日志记录相关的操作，下面的相同。
 * 6、通过@Before注解声明一个建言，此建言直接使用拦截规则作为参数。
 * @author Mask
 *
 */
@Aspect
@Component
public class LogAspect {
	@Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)")
	public void annotationPointCut() {};
	
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截 " + action.name());
	}
	
	@Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则式拦截，" + method.getName());
	}
}
