package com.belmar.daikichipathvariables;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

	
	//testing connection
	@RequestMapping ("/")
	public String hello() {
		return "Hello World";
	}
	
	//travel
	@RequestMapping("/daikichi/travel/{location}")
	public String location(@PathVariable("location")String location) {
		return String.format("Congratulations! You will soon travel to %s", location);
	}
	
	
	//lotto
	@RequestMapping("/daikichi/lotto/{number}")
	public String number(@PathVariable("number")int number) {
		if(number % 2 == 0) {
		return String.format("You will take a grand journey in the near future, but be wary of tempting offers");}
		else {
		return String.format("You have enjoyed the fruits of your labor but now is a great time to spend with family and friends.");}
		
	}
	
	
	
	
	
	
}
