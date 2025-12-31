package com.sandaniel.springboot.demo.rest;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("employees/{theEmployeeId}")
	public Employee findEmployee (@PathVariable int theEmployeeId ) {
		
		// Retrieving the employee data with nullable check
		Employee theEmployee = Optional.ofNullable(employeeService.findById(theEmployeeId))
				.orElseThrow(() -> new RuntimeException("Employee id not found - " +theEmployeeId));
	
		
		
		return theEmployee;
	}
	
}
