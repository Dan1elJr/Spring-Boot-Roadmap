package com.sandaniel.springboot.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sandaniel.springboot.springcoredemo.common.Coach;
import com.sandaniel.springboot.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {

	//Configuring outsoruced component(SwimCoach)
	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}
	
}
