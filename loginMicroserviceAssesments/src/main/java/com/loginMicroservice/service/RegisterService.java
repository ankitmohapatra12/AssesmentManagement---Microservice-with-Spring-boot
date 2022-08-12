package com.loginMicroservice.service;

import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

	String registerUser(String userName, String password, String userLevel);

}
