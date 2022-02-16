package com.belmar.quoteroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/quotes") this would allow for less typing and to put /quotes at the beggining of every route.
public class HomeController {
	@RequestMapping("/") //same thing as app.route
	public String helloWorld() {
		return "Hello World Test";
	}
	@RequestMapping("/quote/funny")
	public String funnyQuote() {
		return  "If I can't scuba what has this all been about";
	}
//	@RequestMapping("/error")
//	public String error() {
//		return "This route has not been established yet, please return to the home page or check file for error";
//	}
	@RequestMapping("/quote/inspirational")
	public String inspireQuote() {
		return "You can do it";
	}
//	
	
}
