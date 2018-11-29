package com.wisely.ch8_6_1.web;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.ch8_6_1.dao.PersonRepository;
import com.wisely.ch8_6_1.domain.Location;
import com.wisely.ch8_6_1.domain.Person;

@RestController
public class DataController {
	
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping("/save")	//1、测试保存方法
	public Person save() {
		Person p = new Person("mask", 22);
		Collection<Location> locations = new LinkedHashSet<Location>();
		Location loc1 = new Location("武汉", "2014");
		Location loc2 = new Location("仙桃", "2011");
		Location loc3 = new Location("杭州", "2018");
		Location loc4 = new Location("郑州", "2017");
		locations.add(loc1);
		locations.add(loc2);
		locations.add(loc3);
		locations.add(loc4);
		p.setLocations(locations);
		return personRepository.save(p);
	}
	
	@RequestMapping("/q1")	//2、测试方法名查询
	public Person q1(String name) {
		return personRepository.findByName(name);
	}
	
	@RequestMapping("q2")	//3、测试@Query查询
	public List<Person> q2(Integer age) {
		return personRepository.withQueryFindByAge(age);
	}
}
