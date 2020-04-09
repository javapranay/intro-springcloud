package com.st.spring.cloud.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World Spring Boot Docker";
	}

}
