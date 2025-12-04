package com.sandaniel.springboot.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "<h1>Spend 30 minutes in batting practice</h1>";
	}

}
