package com.sandaniel.springboot.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandaniel.springboot.demo.entity.Employee;
import com.sandaniel.springboot.demo.service.EmployeeServices;



@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeServices employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeServices theEmployeeService) {
		
		employeeService = theEmployeeService;
	}
	
	@GetMapping("employees")
	public List<Employee> findAll() {
		
		
		return employeeService.findAll();	
		
	}
	
	
}
