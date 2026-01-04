package com.sandaniel.springboot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandaniel.springboot.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
