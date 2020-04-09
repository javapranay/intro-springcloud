package com.st.spring.cloud.demo.filter;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CorsFilter extends ZuulFilter {
	
	private final DiscoveryClient discoveryClient;

	 @Autowired
	 public CorsFilter(DiscoveryClient discoveryClient) {
		 this.discoveryClient = discoveryClient;
	 }
	
	@Override
	public String filterType() {
		return "post";
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
		System.out.println("###### Post Cors filter invoked ######");
		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		final String origin = getOriginFromRequest(request);
		
		if (isValidClient(origin)) {
			System.out.println("###### Valid origin in the request ######");
			final HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
			response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, origin);
		}
		
		return null;
	}
	
	private String getOriginFromRequest(HttpServletRequest request) {
		return StringUtils.hasText(request.getHeader(HttpHeaders.ORIGIN)) ? 
				request.getHeader(HttpHeaders.ORIGIN) : request.getHeader(HttpHeaders.REFERER);
	}
	
	private boolean isValidClient(final String origin) {
		final URI originUri = URI.create(origin);
		final String originToCheck = originUri.getHost() + ":" + originUri.getPort();
		
		return this.discoveryClient.getServices().stream()
					.map(service -> this.discoveryClient.getInstances(service).get(0))
					.anyMatch(serviceInstance -> originToCheck.equalsIgnoreCase(serviceInstance.getHost() + ":" + serviceInstance.getPort()));
	}

}
