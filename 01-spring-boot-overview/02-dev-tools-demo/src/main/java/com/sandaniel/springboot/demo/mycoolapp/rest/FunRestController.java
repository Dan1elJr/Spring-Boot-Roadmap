package com.sandaniel.springboot.demo.mycoolapp.rest;import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController{
	
	// Inject properties for: coach.name and team.name
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "<h1>Coach: " + coachName + ", Team Name: " + teamName+"</h1>";
	}
	
	
	@GetMapping("/")
	public String sayHello() {
		
		return "<h1>Hello World!</h1><br/><hr/>";
	}
	
	//expose a new enpoint for "workout"
	@GetMapping("/workout")
	public String getdailyWorkout() {
		return "<h1>Run a hard 5k</h1><br/><hr/>";
	}
	
	//expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getdailyFortune() {
		return "<h1>Today is your lucky day</h1><br/><hr/>";
	}
}
