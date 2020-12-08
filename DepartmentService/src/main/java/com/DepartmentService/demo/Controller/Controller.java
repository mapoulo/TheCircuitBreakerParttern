package com.DepartmentService.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DepartmentService.demo.Models.Department;
import com.DepartmentService.demo.Service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class Controller {
	
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/")
	public void saveDepartment(@RequestBody Department department) {
		log.info("Inside the saveDepartment in the Department controller");

		service.saveDepartment(department);
	}
	
	@GetMapping("/")
	public List<Department>  getAllDepartments(){
		log.info("Inside the getAllDepartment in the Department controller");
		return service.getAllDepartments();
	}
	
	@GetMapping("/{id}")
	public Optional<Department> getDepartmentById(@PathVariable int id) {
		log.info("Inside the getDepartmentById in   in the Department controller");
		return service.getDepartmentById(id);
	}

}
