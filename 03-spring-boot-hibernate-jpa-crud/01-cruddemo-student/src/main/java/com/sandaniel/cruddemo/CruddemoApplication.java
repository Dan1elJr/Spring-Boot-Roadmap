package com.sandaniel.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sandaniel.cruddemo.dao.StudentDAO;
import com.sandaniel.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return runner -> {
			createStudent(studentDAO);
		};
		
	}

	private void createStudent(StudentDAO studentDAO) {
		
		// Create the student object
		System.out.println("Creating a new student object....");
		Student tempStudent = new Student ("Daniel","San","daniel@san.com");
	
		// Save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		
		
		// Display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
