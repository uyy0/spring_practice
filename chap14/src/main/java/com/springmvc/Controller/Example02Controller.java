package com.springmvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam02")
public class Example02Controller {
	public @ResponseBody Person submit() {
		Person person = new Person();
		person.setName("HongGilSon");
		person.setAge("20");
		person.setEmail("Hong@naver.com");
		System.out.println(person);
		return person;
	}

}
