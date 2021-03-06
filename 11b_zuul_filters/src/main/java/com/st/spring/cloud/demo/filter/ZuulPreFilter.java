package com.st.spring.cloud.demo.filter;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

@Component
public class ZuulPreFilter extends ZuulFilter {
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public Object run() {
		System.out.println("######## Zuul Pre Filter Called ########");
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	

}
