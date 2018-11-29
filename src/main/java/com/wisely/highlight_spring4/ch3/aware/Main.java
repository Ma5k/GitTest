package com.wisely.highlight_spring4.ch3.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring的依赖注入的最大亮点就是你所有的Bean对Spring容器的存在是没有意识的。
 * 即你可以将你的容器替换成别的容器，如Google Guice，这是Bean之间的耦合度很低。
 * 	但是实际项目中，你不可避免的要用到Spring容器本身的功能资源，这时你的Bean必须要意识到Spring容器的存在，
 * 	才能调用Spring所提供的资源，这就是所谓的Spring Aware。
 * 	其实Spring Aware本来就是Spring设计用来框架内部使用的，若使用了Spring Aware，你的Bean将会和Spring框架耦合。
 * 
 * Spring Aware的目的是为了让Bean获得Spring容器的服务。因为ApplicationContext接口集成了MessageSource接口、
 * ApplicationEventPulisher接口和ResourceLoader接口，所以Bean继承ApplicationContextAware可以获得容器所有的服务，
 * 但原则上我们还是用到什么接口，就实现什么接口。
 * @author Mask
 *
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
		AwareService awareService = context.getBean(AwareService.class);
		awareService.outputResult();
		
		context.close();
	}
}
