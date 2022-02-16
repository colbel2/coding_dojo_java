package com.belmar.hellopets;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
	@RequestMapping ("/")
	public String home() {
		return "Hello World";
	}
	
	@RequestMapping ("/pets")
	public String pets(@RequestParam(value="q", required = false)String queryparam, @RequestParam(value="breed",required = false)String breed) { //queryparam is a variable and can be named anything
		System.out.println("This is the query param! " + queryparam);
		if(queryparam==null) {
			return "This is the default pet. Guest User";
		}else if(breed==null) {
			return String.format("This is %s, he is a good boy or she is a good girl", queryparam);
		}else {
			return String.format("Pet Name: %s \n Pet Breed: %s",queryparam, breed);
		}
		
	}
}
