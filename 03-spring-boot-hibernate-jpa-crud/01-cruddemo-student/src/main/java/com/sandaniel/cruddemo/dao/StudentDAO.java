package com.sandaniel.cruddemo.dao;

import java.util.List;

import com.sandaniel.cruddemo.entity.Student;

public interface StudentDAO {

		void save(Student theStudent);
		
		Student findById(Integer id);
		
		List<Student> findAll();
		
		List<Student> findByLastName(String theLastName);
		
		void updateStudent(Student theStudent);
		
		void delete(Integer id);
		
		int deleteAll();
}
