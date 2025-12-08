package com.sandaniel.springboot.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandaniel.springboot.springcoredemo.common.Coach;

@RestController
public class DemoController {
	
	//define a private field for 
	private Coach myCoach;
	
	private Coach anotherCoach;
	
	@Autowired
	public void DemoController (@Qualifier("cricketCoach")Coach theCoach,
			@Qualifier("cricketCoach")Coach theAnotherCoach) {
		System.out.println("In constructor: "+getClass().getSimpleName());
		myCoach = theCoach;
		anotherCoach = theAnotherCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	@GetMapping("check")
	public String check() {
		return "Comparing beans: mycoach == anotherCoach, "+(myCoach==anotherCoach);
	}
	
}
