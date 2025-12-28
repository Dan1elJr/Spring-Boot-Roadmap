package com.sandaniel.springboot.demo.dao;

import java.util.List;

import com.sandaniel.springboot.demo.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save (Employee theEmployee);
	
	void deleteById(int id);
}
