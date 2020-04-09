package com.example.demo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-one")
public interface ServiceOneFeignClient {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String invokeServiceOne();


}
