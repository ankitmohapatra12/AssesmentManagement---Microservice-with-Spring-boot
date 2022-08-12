package com.Employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.model.Assesment;
import com.Employee.repository.AssesmentRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private AssesmentRepository repo;
	
	
	@Override
	public String saveAssesment(Assesment assesment1) {
		String res ="success";
		try
		{
			repo.saveAndFlush(assesment1);
			if(res.equalsIgnoreCase("success")) {
			return res;
			}
			
		}catch (Exception e) {
			
			System.out.println("FAILED TO REGISTER ASSESMENT !");
			return "Failed";
		}
		return "Success";
	}

}
