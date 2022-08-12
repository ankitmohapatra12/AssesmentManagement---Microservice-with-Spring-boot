package com.loginMicroservice.service;

import org.springframework.stereotype.Service;

import com.loginMicroservice.model.User;
import com.loginMicroservice.payloads.AssignmentDto;

@Service
public interface LoginService {

	User findByUserName(String name);

	String saveTechnicalRegistrationPage(AssignmentDto assigment,String serviceName);



}
