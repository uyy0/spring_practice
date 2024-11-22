package com.springmvc.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam03")
public class Example03Controller {
	@GetMapping
	public Person submit() {
		Person person = new Person();
		person.setName("HongGilSon");
		person.setAge("20");
		person.setEmail("Hong@naver.com");
		System.out.println(person);
		return person;
	}
}
