package com.loginMicroservice.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegisterServiceImpl implements RegisterService {
	

	@Autowired
	private RestTemplate restTemplate;

	
	
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Override
	public String registerUser(String userName, String password, String userLevel) {
		String res = "";
		ServiceInstance instance=loadBalancerClient.choose("AssesmentRegistration-service");
		URI uri=instance.getUri();
		String url=uri.toString()+"/register-user/"+userName+"/"+password+"/"+userLevel;
		res = restTemplate.getForObject(url, String.class);
		return res;
	}

}
