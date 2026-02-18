package com.sandaniel.springboot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sandaniel.springboot.demo.entity.Employee;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
