package com.wisely.highlight_spring4.ch3.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1、@Conditional注解根据满足某一个特定条件创建一个特定的Bean。
 * 比如说，当某一个jar包在一个类路径下的时候，自动配置一个或多个Bean；
 * 或者只有某个Bean被创建才会创建另外一个Bean。总的来说，
 * 就是根据特定条件来控制Bean的创建行为，这样我们可以利用这个特性进行一些自动的配置。
 * @author Mask
 *
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
		ListService listService = context.getBean(ListService.class);
		
		System.out.println(context.getEnvironment().getProperty("os.name")
				+ "系统下的列表命令为："
				+ listService.showListCmd());
	}
}
