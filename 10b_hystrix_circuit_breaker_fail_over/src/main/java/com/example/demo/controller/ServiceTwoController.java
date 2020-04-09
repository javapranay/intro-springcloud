package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.ServiceOneFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ServiceTwoController {
	
	private final ServiceOneFeignClient feignClient;
	
	@Autowired
	public ServiceTwoController(final ServiceOneFeignClient feignClient) {
		this.feignClient = feignClient;
	}

	@RequestMapping(path = "/hystrix/test", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "handleFailure")
	public String feignTest() {
		System.out.println("********* Invoking Service One *********");
		return feignClient.invokeServiceOne();
	}
	
	private String handleFailure() {
		return "Hello from Hystrix fallback method";
	}
	
	
	
	
	
	
	
	
	
}
