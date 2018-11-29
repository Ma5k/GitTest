package com.wisely.highlight_spring4.ch2.perpost;

/**
 * 	在开发过程中，会遇到在Bean使用之前或者之后做些必要的操作，
 * 	Spring对Bean的生命周期的操作提供了支持。在使用Java配置和注解配置下提供如下两种方式：
 * 	1、Java配置方式：使用@Bean的initMethod和destroyMethod(相当于xml配置的init-method和destroy-method)。
 * 	2、注解方式：利用JSR-250的@PostConstruct和@PreDestroy。
 * @author Mask
 *
 */
public class BeanWayService {
	public void init() {
		System.out.println("@Bean-init-method");
	}
	
	public BeanWayService() {
		super();
		System.out.println("初始化构造函数-BeanWayService");
	}
	
	public void destroy() {
		System.out.println("@Bean-destroy-method");
	}
}
