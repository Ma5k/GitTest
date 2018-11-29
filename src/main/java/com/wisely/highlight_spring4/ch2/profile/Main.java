package com.wisely.highlight_spring4.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1、先将活动的Profile设置为prod。
 * 2、后置注册Bean配置类，不然会报Bean未定义的错误
 * 3、刷新容器
 * @author Mask
 *
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(ProfileConfig.class);
		context.refresh();

		DemoBean demoBean = context.getBean(DemoBean.class);

		System.out.println(demoBean.getContent());

		context.close();
	}
}
