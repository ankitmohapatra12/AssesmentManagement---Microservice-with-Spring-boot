package com.Admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Admin.controller.model.Assesment;
import com.Admin.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@ResponseBody
	@GetMapping("getAllEmployeeRegistrations")
	public List<Assesment> getAllRegistrations(){
		
		List<Assesment> assesments = new ArrayList<>();
		try {
			assesments = adminService.getAllRegistrations();
		}catch (Exception e) {
			System.out.println(e);
		}
		return assesments;
	}
	
}
