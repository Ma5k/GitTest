package com.wisely.ch9_3_5;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	RabbitTemplate rabbitTemplate;	//1、可注入SpringBoot为我们自动配置好的RabbitTemplate。
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean	//2、定义目的地即队列，队列名称为my-queue
	public Queue wiselyQueue() {
		return new Queue("my-queue");
	}
	
	public void run(String... args) throws Exception {
		rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候");	//通过RabbitTemplate的convertAndSend方法向队列my-queue发送消息
	}
}
