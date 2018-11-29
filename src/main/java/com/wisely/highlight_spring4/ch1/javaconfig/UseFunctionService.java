package com.wisely.highlight_spring4.ch1.javaconfig;

import com.wisely.highlight_spring4.ch1.javaconfig.FunctionService;

/**
 * 1、此处没有使用@Service声明Bean
 * 2、此处没有使用@Autowired注解注入Bean
 * @author Mask
 *
 */
public class UseFunctionService {

	FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String SayHello(String word){
        return functionService.sayHello(word);
    }

}