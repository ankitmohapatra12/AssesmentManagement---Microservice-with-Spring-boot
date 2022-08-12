package com.loginMicroservice.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.loginMicroservice.model.User;
import com.loginMicroservice.payloads.AssignmentDto;
import com.loginMicroservice.service.LoginService;
import com.loginMicroservice.service.RegisterService;



@Controller
@EnableAutoConfiguration
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private LoginService loginService;

	
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping(value="/login")
	public String loginMvc() {
		return "login";
	}
	
	@GetMapping("/Employee/scheduleTechnicalAssesment")
	public String getTechnicalAssesment(HttpSession session,HttpServletRequest req,Model model) {
		try {
			 session = req.getSession();
			if(session.getAttribute("role").equals("ADMIN")) {
				return "redirect:/login";
			}

			
		
		}catch (Exception e) {
			log.error("Error while fetching session ! --> LoginControlleR::getTechnicalAssesment()");
			System.out.println(session.getId());
			return "redirect:/login";
		}	
		return "technicalAssesments";
	}
	
	
	@GetMapping("/Employee/behavioralTechnicalAssesment")
	public String getBehavioralAssesment(HttpSession session,HttpServletRequest req,Model model) {
		try {
			 session = req.getSession();
			if(session.getAttribute("role").equals("ADMIN")) {
				return "redirect:/login";
			}
			
			
		
		}catch (Exception e) {
			log.error("Error while fetching session ! --> LoginControlleR::getBehavioralAssesment()");
			System.out.println(session.getId());
			return "redirect:/login";
		}	
		return "BehavioralAssesments";
	}
	
	


	@SuppressWarnings("rawtypes")
	@Autowired
	private CircuitBreakerFactory factory;
	
	@GetMapping("/Admin/getAllEmployeeAssesments")
	public String getAllEmployeeAssesments(HttpSession session,HttpServletRequest req,Model model) {
		
		try {
			session = req.getSession();
			if(session.getAttribute("role").equals("EMPLOYEE")) {
				return "redirect:/login";
			}
			
		     CircuitBreaker circuitBreaker =  factory.create("getBreaker");
		     ServiceInstance instance=loadBalancerClient.choose("AssesmentAdmin-service");
			 URI uri=instance.getUri();
			 String url=uri.toString()+"/getAllEmployeeRegistrations";
			
			@SuppressWarnings("unchecked")
			List<AssignmentDto> assignmentDto = (List<AssignmentDto>) circuitBreaker.run(() -> restTemplate.getForObject(uri, List.class),
	                throwable -> getAllRegistrations(model));
			System.out.println(assignmentDto);
			model.addAttribute("assesment", assignmentDto);
		}catch (Exception e) {
			System.out.println("error in getAllEmployeeAssesments()");
			return "employeeRegistrations";
		}	
		return "employeeRegistrations";
	}
	
	

	public String getAllRegistrations(Model model){
		
		List<AssignmentDto> assesments = new ArrayList<>();
		assesments.add(new AssignmentDto(1,"JAVA","12-7-2022","TECHNICAL", 1));
		assesments.add(new AssignmentDto(2,"PROFESSIONAL ETIQUE","8-7-2022","BEHAVIORAL", 2));
		model.addAttribute("assesment", assesments);
		System.out.println(model);
		return "employeeRegistrations";
	}
	
	

	@PostMapping("/Employee/saveBehavioralRegistration")
	public String saveBehavioralAssesments(
			@RequestParam("user_id") int user_id,
			@RequestParam("assesment") String assesment,
			@RequestParam("date") String dateFiled,
			@RequestParam("type") String assesmentType,
			Model model,
			HttpSession session,HttpServletRequest req) {
		    AssignmentDto assignment =  new AssignmentDto();
	
		
			if(req.getSession()==null) {
				return "redirect:/login";
			}
			
			try {
				session = req.getSession();
				
				if(session.getAttribute("role").equals("ADMIN")) {
					return "redirect:/login";
				}
				assignment.setUser_id(user_id);
				assignment.setAssesmentType(assesmentType);
				assignment.setAssesments(assesment);
				assignment.setDateField(dateFiled);
				String response = loginService.saveTechnicalRegistrationPage(assignment,"AssesmentEmployee-service");
				if(response.equalsIgnoreCase("success"))
				{
					model.addAttribute("success", "Scheduled Behavioral assesment for course "+assesment+" on "+dateFiled);
					return "BehavioralAssesments";
				}
			}catch (Exception e) {
				log.error("Error while fetching session ! --> LoginControlleR::getTechnicalAssesment()");
				model.addAttribute("err","Failed to register Behavioral assesment !");
				return "BehavioralAssesments";
			}	
			return "BehavioralAssesments";
	}
	
	
	@PostMapping("/Employee/savetechnicalRegistration")
	public String saveTechnicalAssesment(
			@RequestParam("user_id") int user_id,
			@RequestParam("assesment") String assesment,
			@RequestParam("date") String dateFiled,
			@RequestParam("type") String assesmentType,
			Model model,
			HttpSession session,HttpServletRequest req) {
		if(req.getSession()==null) {
			return "redirect:/login";
		}
		AssignmentDto assignment =  new AssignmentDto();
		try {
			session = req.getSession();
			if(session.getAttribute("role").equals("ADMIN")) {
				return "redirect:/login";
			}
			
			assignment.setUser_id(user_id);
			assignment.setAssesmentType(assesmentType);
			assignment.setAssesments(assesment);
			assignment.setDateField(dateFiled);
			String response = loginService.saveTechnicalRegistrationPage(assignment,"AssesmentEmployee-service");
			
			if(response.equalsIgnoreCase("success"))
			{
				model.addAttribute("success", "Scheduled technical assesment for course "+assesment+" on "+dateFiled);
				return "technicalAssesments";
			}
		}catch (Exception e) {
			log.error("Error while fetching session ! --> LoginControlleR::getTechnicalAssesment()");
			System.out.println(e);
			model.addAttribute("err","Failed to register technical assesment !");
			return "technicalAssesments";
		}	
		return "technicalAssesments";
	}

	
	@PostMapping("/Home")
	public String loginHomePage(@RequestParam("userName") String name,
								@RequestParam("password") String password ,
								@RequestParam("userLevel") String userLevel ,
								Model model,HttpSession session) {
		
		User user;
		try {
			user = loginService.findByUserName(name);
		}
		catch (Exception e) {
			System.out.println("User not found !!");
			model.addAttribute("error","User not found , please register first !!");
			return "login";
		}
	
			
		if(user!=null) {
			if(password.equals(user.getPassword()))
			{
				if(!userLevel.equalsIgnoreCase(user.getUserLevel())) {

					model.addAttribute("error","This user with "+userLevel+" role is unauthorized");
					return "login";
				}
				if(userLevel.equalsIgnoreCase("EMPLOYEE") && userLevel.equalsIgnoreCase(user.getUserLevel())) {
					session.setAttribute("UserName",name);
					session.setAttribute("user_id",user.getUser_id());
					session.setAttribute("role",user.getUserLevel());
				
					return "redirect:/Employee/Homepage";
				}
				if(userLevel.equalsIgnoreCase("ADMIN") && userLevel.equalsIgnoreCase(user.getUserLevel())) {
					session.setAttribute("UserName",name);
					session.setAttribute("user_id",user.getUser_id());
					session.setAttribute("role",user.getUserLevel());
					return "redirect:/Admin/Homepage";
				}
			}
			else {
				model.addAttribute("error","Incorrect Password ! please try again.");
				return "login";
			}
		}
		model.addAttribute("error","User not found , please register first !!");
		//System.out.println(model);
		return "login";
	}
	
	
		
		

	@GetMapping("/Employee/Homepage")
	public String employeeHomePage(HttpSession session,HttpServletRequest req) {
		try {
			 session = req.getSession();
			if(session.getAttribute("role").equals("ADMIN")) {
				return "redirect:/login";
			}
		}catch (Exception e) {
			log.error("Error while fetching session ! --> LoginControlle::employeeHomePage()");
			return "redirect:/login";
		}
		return "homePage";
	}
	
	
	@GetMapping("/Admin/Homepage")
	public String adminHomePage(HttpSession session,HttpServletRequest req) {
		try {
			 session = req.getSession();
			if(session.getAttribute("role").equals("EMPLOYEE")) {
				return "redirect:/login";
			}
		}catch (Exception e) {
			log.error("Error while fetching session ! --> LoginControlle::adminHomePage()");
			return "redirect:/login";
		}
			
		return "adminhomePage";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
		
		return "redirect:/login";
	}
	
	@GetMapping("/register")
	public String registrationPage() {
		
		return "register";
	}
	
	
	@PostMapping("/registerUser")
	public String goToRegisterMicroservice(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam("confirmpassword") String confirmpassword,
			@RequestParam("userLevel") String userLevel
			,Model model) {
		
		String result="";
		if(confirmpassword.equals(password)) {
			
		    result = registerService.registerUser(userName,password,userLevel);
			model.addAttribute("registerErr",result);
		}
		else {
			model.addAttribute("registrationError","Password didn't match !");
			model.addAttribute("userName",userName);
		}
		return "register";
	}
	
	
}
