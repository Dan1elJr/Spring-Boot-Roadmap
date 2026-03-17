package com.sandaniel.cruddemo.dao;

import com.sandaniel.cruddemo.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class AppDAOImpl implements AppDAO{
		
	private EntityManager entityManager;
	
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		
		entityManager.persist(theInstructor);
	}

}
