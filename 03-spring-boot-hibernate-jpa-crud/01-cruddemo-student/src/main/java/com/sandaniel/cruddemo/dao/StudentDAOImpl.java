package com.sandaniel.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sandaniel.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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

	@Override
	public Student findById(Integer id) {
		
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		
		// Create query
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName ASC",Student.class);
		
		// Return query results
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		
		// Create query
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
		
		// Set parameter
		theQuery.setParameter("theData", theLastName);
		
		// Return query results
		return theQuery.getResultList();
	}

}
