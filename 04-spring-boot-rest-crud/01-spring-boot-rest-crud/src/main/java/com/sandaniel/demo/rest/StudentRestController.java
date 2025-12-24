package com.sandaniel.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandaniel.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// Define endpoint for "/students" - return a list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Daniel","Junior"));
		theStudents.add(new Student("Shyrlei","Silva"));
		theStudents.add(new Student("John","Doe"));
		
		
		return theStudents;
	}
}
