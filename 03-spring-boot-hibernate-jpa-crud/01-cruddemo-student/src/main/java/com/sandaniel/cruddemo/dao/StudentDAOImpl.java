package com.sandaniel.cruddemo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sandaniel.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	// Define field for entity manager
	private EntityManager entityManager;
	
	// Inject entity manager using constructor injection
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	// Implements save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		
		entityManager.persist(theStudent);
		
	}

}
