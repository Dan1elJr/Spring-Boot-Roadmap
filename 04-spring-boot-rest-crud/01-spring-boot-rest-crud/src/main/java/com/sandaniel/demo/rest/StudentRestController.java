package com.sandaniel.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandaniel.demo.entity.Student;

import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Daniel","Junior"));
		theStudents.add(new Student("Shyrlei","Silva"));
		theStudents.add(new Student("John","Doe"));
	}
	
	// Define endpoint for "/students" - return a list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	
	// Define endpoint for "/student/{studentId}" - return a student at index
	
	@GetMapping("/student/{theStudentId}")
	public Student getStudentById(@PathVariable int theStudentId){
		
		return theStudents.get(theStudentId);
	}
}
