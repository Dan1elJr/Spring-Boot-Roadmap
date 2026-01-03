package com.sandaniel.springboot.demo.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandaniel.springboot.demo.entity.Employee;
import com.sandaniel.springboot.demo.service.EmployeeServices;

import tools.jackson.databind.json.JsonMapper;



@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeServices employeeService;
	private JsonMapper jsonMapper;
	
	@Autowired
	public EmployeeRestController(EmployeeServices theEmployeeService, JsonMapper theJsonMapper) {
		
		employeeService = theEmployeeService;
		jsonMapper = theJsonMapper;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		
		
		return employeeService.findAll();	
		
	}
	
	@GetMapping("/employees/{theEmployeeId}")
	public Employee findEmployee (@PathVariable int theEmployeeId ) {
		
		// Retrieving the employee data with nullable check
		Employee theEmployee = Optional.ofNullable(employeeService.findById(theEmployeeId))
				.orElseThrow(() -> new RuntimeException("Employee id not found - " +theEmployeeId));
	
		
		
		return theEmployee;
	}
	
	// add mapping for POST / employees - add new employee
	
	@PostMapping("/employees")
	public Employee saveEmployee (@RequestBody Employee theEmployee ) {
		
		//also just in case the pass an id in JSON .... set id to 0
		// this is to force a save of new item.... instead of update
		
		theEmployee.setId(0);
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	@PatchMapping("/employees/{theEmployeeId}")
	public Employee pathEmploye (@PathVariable int theEmployeeId , @RequestBody Map <String,Object> patchPayload) {
		
		// Retrieving the employee data with nullable id check
		Employee theEmployeeRetrieved = Optional.ofNullable(employeeService.findById(theEmployeeId))
								.orElseThrow(() -> new RuntimeException("Employee id not found - " +theEmployeeId));
		
		// Check if  patchpayload constains id into
		if(patchPayload.containsKey("id")) {
			throw new RuntimeException("Employee id not allowed in request body");
		}
		
		// Patching the objects before persist
		Employee patchedEmployee = jsonMapper.updateValue(theEmployeeRetrieved, patchPayload);
		
		// Persisting in database
		Employee dbEmployee = employeeService.save(patchedEmployee);
		
		return dbEmployee;
	}
	
	@DeleteMapping("/employees/{theEmployeeId}")
	public String deleteEmployee (@PathVariable int  theEmployeeId) {
		// Retrieving the employee data with nullable id check
				Employee theEmployeeRetrieved = Optional.ofNullable(employeeService.findById(theEmployeeId))
										.orElseThrow(() -> new RuntimeException("Employee id not found - " +theEmployeeId));
	
		employeeService.deleteById(theEmployeeRetrieved.getId());
				
		return "Deleted employee id - " + theEmployeeRetrieved.getId() ;
	}
	
	
}
