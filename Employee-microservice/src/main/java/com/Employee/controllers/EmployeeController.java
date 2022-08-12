package com.Employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Employee.model.Assesment;
import com.Employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	
	

	@ResponseBody
	@PostMapping("/saveTechnicalRegistration")
	public String registerTechnicalAssesment(@RequestBody Assesment assesment1
			,Model model) {

		String result ="";
		try {
			result = service.saveAssesment(assesment1);
			
		}catch (Exception e) {
			
			System.out.println("Some execption occured while registering"+e);
			return result;
		}
		return result.toString();
	}
}
