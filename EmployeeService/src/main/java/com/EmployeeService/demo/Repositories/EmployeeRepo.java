package com.EmployeeService.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeService.demo.Models.Employee;

public interface EmployeeRepo  extends JpaRepository<Employee, Integer>{

	Employee findEmployeeById(int id);

}
