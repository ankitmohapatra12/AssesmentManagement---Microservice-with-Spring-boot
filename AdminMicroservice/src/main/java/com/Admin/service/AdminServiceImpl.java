package com.Admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Admin.Repository.AdminRepository;
import com.Admin.controller.model.Assesment;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public List<Assesment> getAllRegistrations() {
		List<Assesment> assesments = new ArrayList<Assesment>();
		try {
			assesments = adminRepo.findAll();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return assesments;
	}
}
