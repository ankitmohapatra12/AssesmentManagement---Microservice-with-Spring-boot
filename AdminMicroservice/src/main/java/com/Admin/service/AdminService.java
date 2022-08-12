package com.Admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Admin.controller.model.Assesment;

@Service
public interface AdminService {

	List<Assesment> getAllRegistrations();

}
