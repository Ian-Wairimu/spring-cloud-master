package com.example.demo;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ryan Baxter
 */
@Service
@EnableFeignClients
@EnableZuulProxy
public class NameService {
//	private static final String URL = "http://localhost:7070";
//	private RestTemplate rest;
//
//	public NameService(RestTemplate rest) {
//		this.rest = rest;
//	}
	private NameFeignClient nameFeignClient;

	public NameService(NameFeignClient nameFeignClient) {
		this.nameFeignClient = nameFeignClient;
	}

	public String getName() {
		return nameFeignClient.getName();
	}

	@FeignClient("name")
	static interface NameFeignClient{
		@RequestMapping("/")
		public String getName();
	}
}
