package com.EmployeeService.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.EmployeeService.demo.Models.Employee;
import com.EmployeeService.demo.Service.EmployeeService;
import com.EmployeeService.demo.ValueObject.Department;
import com.EmployeeService.demo.ValueObject.RestTemplateVO;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/employees")
@Slf4j
public class Controller {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private RestTemplate resTtemplate;
	
	@PostMapping("/")
	public void saveEmployee(@RequestBody Employee employee) {
		log.info("Inside the saveEmployee in the Employee controller");

		service.saveEmployee(employee);
	}
	
	
	
	
	@GetMapping("/")
	public List<Employee> getAllEmployees(){
		log.info("Inside the getAllEmployees in the Employee controller");

		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public RestTemplateVO getEmployee(@PathVariable int id) {
		log.info("Inside the getEmployee in the Employee controller");

		RestTemplateVO restTemplateVO = new RestTemplateVO();
		Employee employee = service.getEmployeeById(id);
		Department department = resTtemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+id, Department.class);
		restTemplateVO.setDepartment(department);
		restTemplateVO.setEmployee(employee);
		return restTemplateVO;
	}

}
