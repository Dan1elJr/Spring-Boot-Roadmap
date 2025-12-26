package com.sandaniel.demo.rest;

public class StudentNotFoundException extends RuntimeException {
	
	static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public StudentNotFoundException(String message) {
		super(message);
		
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	
	
}
