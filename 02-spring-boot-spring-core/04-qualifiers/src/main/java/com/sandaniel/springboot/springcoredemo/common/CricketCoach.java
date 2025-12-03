package com.sandaniel.springboot.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "<h1>Practice fast bowling for 15 minutes</h1>";
	}

}
