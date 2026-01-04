package com.sandaniel.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandaniel.springboot.demo.dao.EmployeeRepository;
import com.sandaniel.springboot.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {

		return employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ID not found" + id));
	}
	
	@Override
	public Employee save(Employee theEmployee) {

		return employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int id) {

		employeeRepository.deleteById(id);

	}

}
