package com.belmar.playerpathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping ("/")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping ("/sports/team/{teamName}")
	public String showTeam(@PathVariable("teamName")String teamName) {
		return String.format("Team: %s",teamName);
	}
	
	@RequestMapping ("/sports/player/{playerName}")
	public String showPlayer(@PathVariable("playerName")String playerName) {
		return String.format("%s is your favorite player!",playerName);
	}
} 