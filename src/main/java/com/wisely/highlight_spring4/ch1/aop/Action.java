package com.wisely.highlight_spring4.ch1.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Spring支持AspectJ的注解式切面编程
 * 1、使用@Aspect声明是一个切面
 * 2、使用@After、@Before、@Around定义建言（advice），可直接将拦截规则（切点）作为参数。
 * 3、其中@After、@Before、@Around参数的拦截规则为切点（PointCut），为了使切点复用，
 * 	可使用@PointCut专门定制拦截规则，然后在@After、@Before、@Around的参数中调用。
 * 4、其中符合条件的每一个被拦截处为连接点（JoinPoint）。
 * 	注解本身是没有功能的，就和xml一样。注解和xml都是一种元数据，元数据即解释数据的数据，这就是所谓的配置。
 * 	注解的功能来自使用这个注解的地方。
 * @author Mask
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
	String name();
}
