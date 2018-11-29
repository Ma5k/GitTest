package com.wisely.highlight_spring4.ch1.di;

import org.springframework.stereotype.Service;
/**
 * 1、使用@Service注解声明当前FunctionService类是Spring管理的一个Bean。
 * 其中，使用@Component、@Service、@Repository、@Controller是等效的，可根据需要选用
 * @author Mask
 *
 */
@Service
public class FunctionService {
	public String sayHello(String word) {
		return "Hello " + word + " !";
	}
}
