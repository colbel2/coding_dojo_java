package com.belmar.daikichiroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
	//welcome text on page
	@RequestMapping("/")
	public String welcome() {
	return "Welcome!";}
	
	//today's fortune
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors";
	}
	
	//tomorrow's fortune
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
}
