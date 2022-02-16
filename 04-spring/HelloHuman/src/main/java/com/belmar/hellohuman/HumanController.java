package com.belmar.hellohuman;


	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	@RestController

	public class HumanController {
		@RequestMapping ("/")
		public String home() {
			return "Hello Human";
		}
		
		@RequestMapping ("/human")
		public String humans(@RequestParam(value="name", required = false)String name, @RequestParam(value="last",required = false)String last_name) { //queryparam is a variable and can be named anything
			System.out.println("This is the query param! " + name);
			if(name==null) {
				return "This is the default human. Guest User";
			}else if(last_name==null) {
				return String.format("This is %s", name);
			}else {
				return String.format("Name: %s \n Last Name: %s",name, last_name);
			}
			
		}
	}


