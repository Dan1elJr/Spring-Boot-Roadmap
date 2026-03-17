package com.sandaniel.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sandaniel.cruddemo.dao.AppDAO;
import com.sandaniel.cruddemo.entity.Instructor;
import com.sandaniel.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO) {
		
		return runner -> {
			createInstructor(appDAO);
		};
	}
	
	private void createInstructor(AppDAO appDAO) {
		
		// Create the instructor
		Instructor tempInstructor = new Instructor("Daniel","San","sandaniel@gmail.com");
		
		// Create the instrucotr detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http//ww.sandaniel.com/youtube","Luv 2 code!!!");
		
		// associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		// Save the instructor
		
		// NOTE: this will ALSO save the details object
		// Because of CascadeType.ALL
		
		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);
		
		System.out.println("Done!");
		
	}
	
}
