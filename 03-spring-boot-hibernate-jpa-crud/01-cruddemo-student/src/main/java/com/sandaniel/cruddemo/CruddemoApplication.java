package com.sandaniel.cruddemo;

import java.util.List;

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
			
			// CreateStudent(studentDAO);
			
			// CreateMultipleStudents(studentDAO);
			
			//readStudent(studentDAO);
			
			//queryForStudents(studentDAO);
			
			//queryForStudentsByLastName(studentDAO);
			
			//updateStudent(studentDAO);
			
			//deleteStudent(studentDAO);
			
			deleteAllStudents(studentDAO);
		};
		
	}

	
	

	private void deleteAllStudents(StudentDAO studentDAO) {
		
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int theStudentId = 3;
		
		System.out.println("Deleting student id: " + theStudentId);
		
		studentDAO.delete(theStudentId);
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		
		// Retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		// Change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("John");
		myStudent.setLastName("Doe");
		
		// Update the student
		studentDAO.updateStudent(myStudent);
		
		// Display the update student
		System.out.println("Updated student: "+ myStudent);
		
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		
		List<Student> studentList = studentDAO.findByLastName("Doe");
		
		for(Student tempList : studentList) {
			System.out.println(tempList);
		}
		
	}

	private void queryForStudents(StudentDAO studentDAO) {
		
		// Get a list of students
		List<Student> studentList = studentDAO.findAll();
		
		// Display a list of student
		for(Student tempList : studentList) {
			System.out.println(tempList);
		}
		
	}

	private void readStudent(StudentDAO studentDAO) {
		
		// Create a student object
		System.out.println("Creating a new student object....");
		Student tempStudent = new Student ("John", "Mayer", "mayer@sandaniel.com");
		
		// Save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		
		// Display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);
		
		
		// Retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		
		// Display student
		System.out.println("Found the student: "+ myStudent);
		
		
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		
		//create multiple students
		System.out.println("Creating 3 students objects....");
		Student tempStudent1 = new Student ("Shyrlei","San","shyrlei@san.com");
		Student tempStudent2 = new Student ("Carl","Doe","carl@d.com");
		Student tempStudent3 = new Student ("Paul","George","paul@g.com");
		
		// Save the student objects
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
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
