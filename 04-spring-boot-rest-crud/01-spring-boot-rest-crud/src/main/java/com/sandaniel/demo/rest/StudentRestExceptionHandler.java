package com.sandaniel.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	// Add a exception handling code here
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc){
		
		// Create a StudentErrorRespons
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		
		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());		
		
		// Return ResponseEntity
		return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	// Add a generic exception handler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException (Exception exc){
		
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		
		studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());		
		
		// Return ResponseEntity
		return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
		
	}
}
