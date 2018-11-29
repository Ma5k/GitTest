package com.wisely.highlight_spring4.ch2.perpost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @PostConstruct，在构造代码执行完成之后执行
 * @PreDestroy，在bean销毁之前执行
 * @author Mask
 *
 */
public class JSR250WayService {
	@PostConstruct
	public void init() {
		System.out.println("jsr250-init-method");
	}
	
	public JSR250WayService() {
		super();
		System.out.println("初始化构造函数-JSR250WayService");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("jsr250-destroy-method");
	}
}
