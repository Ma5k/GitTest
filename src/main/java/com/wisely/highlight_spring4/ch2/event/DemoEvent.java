package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationEvent;
/**
 * 	Spring的事件（Application Event）为Bean与Bean之间的消息通信提供了支持。
 * 	当Bean处理完一个任务后，希望另外一个Bean知道并能做出相应的处理，
 * 	这时我们就需要另外一个Bean监听当前Bean所发送的事件
 * 	Spring的事件需要遵循如下流程：
 * 	1、自定义事件，集成ApplicationEvent。
 * 	2、定义事件监听器，实现ApplicationListener。
 * 	3、使用容器发布事件。
 * @author Mask
 *
 */
public class DemoEvent extends ApplicationEvent{
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public DemoEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
