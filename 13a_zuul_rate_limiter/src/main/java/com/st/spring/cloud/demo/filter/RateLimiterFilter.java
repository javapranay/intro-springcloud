package com.st.spring.cloud.demo.filter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class RateLimiterFilter extends ZuulFilter {
	
	private final RateLimiter rateLimiter;

	 @Autowired
	 public RateLimiterFilter(final RateLimiter rateLimiter) {
		 this.rateLimiter = rateLimiter;
	 }
	
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("###### Pre Rate Limiter filter invoked ######");
		
		try {
			final HttpStatus tooManyRequests = HttpStatus.TOO_MANY_REQUESTS;
			final RequestContext requestContext = RequestContext.getCurrentContext();
			final HttpServletResponse response = requestContext.getResponse();
			
			if (!rateLimiter.tryAcquire()) {
				System.out.println("###### Pre Rate Limiter filter too many requests ######");
			    response.setStatus(tooManyRequests.value());
			    response.getWriter().append(tooManyRequests.getReasonPhrase());
			    
			    requestContext.setSendZuulResponse(false);
			}
		} catch (Exception e) {
			ReflectionUtils.rethrowRuntimeException(e);
		}

		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
