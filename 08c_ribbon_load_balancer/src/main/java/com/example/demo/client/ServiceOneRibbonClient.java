package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceOneRibbonClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String invokeServiceOne() {
		String serviceAURl = "http://service-one/hello";
		
		ResponseEntity<String> response = restTemplate
				.exchange(serviceAURl, HttpMethod.GET, null, String.class);
		return response.getBody();
	}


	
	
	
	
	
	
	
	
	
}
