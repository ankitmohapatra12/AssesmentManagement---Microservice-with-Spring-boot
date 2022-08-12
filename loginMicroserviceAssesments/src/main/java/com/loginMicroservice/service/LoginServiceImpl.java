package com.loginMicroservice.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.loginMicroservice.model.User;
import com.loginMicroservice.payloads.AssignmentDto;
import com.loginMicroservice.repository.UserRepository;


@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;


	
	
	
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Override
	public User findByUserName(String name) {
		User user = new User();
		try {
			user = userRepo.findByName(name);
		}catch (Exception e) {
			log.info("Error fetching user details --> LoginServiceImpl::findByUserName()");
			return user;
		}
		return user;
	}

	@Override
	public String saveTechnicalRegistrationPage(AssignmentDto assignment,String serviceName) {
		
		ServiceInstance instance=loadBalancerClient.choose(serviceName);
		URI uri=instance.getUri();
		String url=uri.toString()+"/saveTechnicalRegistration";
		String res="";
		try {
			res = restTemplate.postForObject(url,assignment,String.class);
		}
		catch(Exception e) {
			log.info("Error fetching user details --> LoginServiceImpl::saveTechnicalRegistrationPage()");
		}
		return res;
	}


	

}
