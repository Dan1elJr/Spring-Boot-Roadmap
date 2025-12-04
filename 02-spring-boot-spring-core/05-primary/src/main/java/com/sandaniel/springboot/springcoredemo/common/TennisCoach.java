package com.sandaniel.springboot.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "<h1>Practice your backend volley</h1>";
	}

}
