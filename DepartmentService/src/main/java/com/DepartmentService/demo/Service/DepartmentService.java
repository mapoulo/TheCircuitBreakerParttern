package com.DepartmentService.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DepartmentService.demo.Models.Department;
import com.DepartmentService.demo.Repositories.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo repo;
	
	
	public void saveDepartment(Department department) {
		repo.save(department);
	}
	
	
	public List<Department>  getAllDepartments(){
		List<Department>  departments = new ArrayList<>();
		repo.findAll().forEach(departments::add);
		return departments;
	}
	
	
	public Optional<Department> getDepartmentById(int id) {
		return repo.findById(id);
	}

}
