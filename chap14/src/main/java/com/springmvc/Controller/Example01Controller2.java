package com.springmvc.Controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Example01Controller2 {
	@GetMapping("/json")
	public String showForm() {
		return "webpage14_02";
	}
	
	@PostMapping("/test")
	public void submit(@RequestBody HashMap<String, Object> map) {
		System.out.println(map);
	}
}
