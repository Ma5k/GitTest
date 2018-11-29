package com.wisely.ch9_3_4;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * JmsListener是Spring4.1为我们提供的一个新特性，用来简化JMS开发。
 * 我们只需要在这个注解的属性destination指定要监听的目的地，即可接收该目的地发送的消息。
 * 此例监听my-destination目的地发送的消息。
 * @author Mask
 *
 */
@Component
public class Receiver {
	@JmsListener(destination="my-destination")
	public void receiveMessage(String message) {
		System.out.println("接收到：<" + message + ">");
	}
}
