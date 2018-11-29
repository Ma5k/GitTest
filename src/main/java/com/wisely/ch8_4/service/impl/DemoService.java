package com.wisely.ch8_4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisely.ch8_4.dao.PersonRepository;
import com.wisely.ch8_4.domain.Person;

@Service
public class DemoService implements com.wisely.ch8_4.service.DemoService {
	
	@Autowired
	PersonRepository personRepository;	//1、可以直接注入我们的PersonRepository的Bean

	@Transactional(rollbackFor= {IllegalArgumentException.class})	//2、使用@Transactional注解的rollbackFor属性，指定特定异常时，数据回滚
	public Person savePersonWithRollBack(Person person) {
		Person p = personRepository.save(person);
		if(person.getName().equals("mask")) {
			throw new IllegalArgumentException("mask已存在，数据将回滚");	//3、硬编码手动触发异常
		}
		return p;
	}

	@Transactional(noRollbackFor= {IllegalArgumentException.class})	//4、使用@Transactional注解的noRollbackFor属性，指定特定异常时，数据回滚
	public Person savePersonWithoutRollBack(Person person) {
		Person p = personRepository.save(person);
		if(person.getName().equals("mask")) {
			throw new IllegalArgumentException("mask已存在，数据不会回滚");
		}
		return p;
	}

}
