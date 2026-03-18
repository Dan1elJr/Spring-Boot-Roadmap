package com.sandaniel.cruddemo.dao;

import com.sandaniel.cruddemo.entity.Instructor;

public interface AppDAO {
	
	void save (Instructor theInstructor);
	Instructor findInstructorById(int theId);
	
}
