package com.EmployeeService.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeService.demo.Models.Employee;
import com.EmployeeService.demo.Repositories.EmployeeRepo;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepo repo;
	
	
	public void saveEmployee(Employee employee) {
		repo.save(employee);
	}
	
	public Employee getEmployeeById(int id) {
		return repo.findEmployeeById(id);
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<>();
		repo.findAll().forEach(employees::add);
		return employees;
	}

}
