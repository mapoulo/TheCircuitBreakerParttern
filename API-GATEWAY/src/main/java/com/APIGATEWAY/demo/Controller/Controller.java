package com.APIGATEWAY.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/employeesFallback")
	public String employee() {
		return "The Employee service is currentyl no available, please try again later";
	}
	
	
	@GetMapping("/departmentFallback")
	public String department() {
		return "The Employee service is currentyl no available, please try again later";
	}
}
