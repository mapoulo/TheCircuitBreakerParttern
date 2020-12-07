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

@RestController
@RequestMapping("/employees")
public class Controller {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private RestTemplate resTtemplate;
	
	@PostMapping("/")
	public void saveEmployee(@RequestBody Employee employee) {
		service.saveEmployee(employee);
	}
	
	
	
	
	@GetMapping("/")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public RestTemplateVO getEmployee(@PathVariable int id) {
		RestTemplateVO restTemplateVO = new RestTemplateVO();
		Employee employee = service.getEmployeeById(id);
		Department department = resTtemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+id, Department.class);
		restTemplateVO.setDepartment(department);
		restTemplateVO.setEmployee(employee);
		return restTemplateVO;
	}

}