package com.sandaniel.springboot.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "<h1>Run a hard 5k</h1>";
	}

}
