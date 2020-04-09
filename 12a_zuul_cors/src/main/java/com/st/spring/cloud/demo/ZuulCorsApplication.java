package com.st.spring.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulCorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulCorsApplication.class, args);
	}
}
