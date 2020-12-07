package com.EmployeeService.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	private String name;

}
