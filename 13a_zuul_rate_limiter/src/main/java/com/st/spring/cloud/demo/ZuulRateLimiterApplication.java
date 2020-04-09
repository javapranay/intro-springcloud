package com.st.spring.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.google.common.util.concurrent.RateLimiter;

@EnableZuulProxy
@SpringBootApplication
public class ZuulRateLimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulRateLimiterApplication.class, args);
	}
	
	@Bean
	 RateLimiter rateLimiter() {
	  return RateLimiter.create(1.0D / 10.0D);
	 }
}
