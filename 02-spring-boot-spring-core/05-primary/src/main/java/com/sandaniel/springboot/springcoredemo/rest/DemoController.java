package com.sandaniel.springboot.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandaniel.springboot.springcoredemo.common.Coach;

@RestController
public class DemoController {
	
	//define a private field for 
	private Coach myCoach;
	
	@Autowired
	public void DemoController (Coach theCoach) {
		myCoach = theCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
}
