package com.wisely.highlight_spring4.ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * 1、使用AnnotationConfigApplicationContext作为spring容器，接受输入一个配置类作为参数
 * 2、获得声明配置的UseFunctionService的bean
 * @author Mask
 *
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
		UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
		System.out.println(useFunctionService.SayHello("di"));
		context.close();
	}
}
