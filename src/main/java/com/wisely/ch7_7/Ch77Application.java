package com.wisely.ch7_7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 	这里只是模拟一个查询，即接受前台传入的personName，
 * 	然后返回Person类，因为这里使用的是@RestController，
 * 	且返回值类型是Person，所以SpringMVC会自动将对象输出为JSON
 * @author Mask
 *
 */
@RestController
@SpringBootApplication
public class Ch77Application {

    @RequestMapping(value="/search",produces={MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName) {
        return new Person(personName,32,"hefei");
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch77Application.class, args);
    }
}
