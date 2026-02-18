package com.sandaniel.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandaniel.springboot.demo.dao.EmployeeDAO;
import com.sandaniel.springboot.demo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
	
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		
		return employeeDAO.save(theEmployee);
	}
	
	@Transactional
	@Override
	public void deleteById(int id) {
		
		employeeDAO.deleteById(id);
		
	}
	
	
	
	
}
