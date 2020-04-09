package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOneController {
	
	@Value("${service.name}")
	private String serviceName;
	
	@GetMapping("/serviceone/prop")
	public String getProp() {
		return "Property name: " + serviceName;
	}

	
	
	
	
	
	
	
	
	
	
}
