package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.model.User;
import com.registration.repository.UserRepository;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserRepository userRepo;
	

	
	@RequestMapping("/register-user/{userName}/{password}/{userLevel}")
	public String registerUser(
			@PathVariable("userName") String userName,
			@PathVariable("password") String password,
			@PathVariable("userLevel") String userLevel) {
	    Object u = new User();
		User user = new User();
		try {
			u = userRepo.findByName(userName);
			
			if(u==null) {
				user.setName(userName);
				user.setPassword(password);
				user.setUserLevel(userLevel);
				user.setActive(false);
			}
			else {
				return "User already exists ! please login .";
			}
		}catch (Exception e) {
			System.out.println("Error while finding user");
			return "User Exists !";
		}
		try {
		userRepo.save(user);
		}catch (Exception e) {
			System.out.println("Failed to save user !"); 
			return "Failed to save user !!";
		}
		
		return "Succesfully registered !!";
	}
}
