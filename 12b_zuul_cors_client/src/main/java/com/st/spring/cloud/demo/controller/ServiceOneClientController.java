package com.st.spring.cloud.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceOneClientController {
	
	@GetMapping("/hello")
	public String getIndexPage() {
		return "hello";
	}

	
	
	
	
	
	
	
	
	
	
}
