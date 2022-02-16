package com.belmar.omikujiform;

//import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/omikuji")
	public String home() {
		return "index.jsp";
	}
	

	@PostMapping("/process_appointment")
	public String process(
			@RequestParam("pick_any") Integer pick_any,
			@RequestParam("city") String city,
			@RequestParam("name") String name,
			@RequestParam("activity") String activity,
			@RequestParam("living") String living,
			@RequestParam("nice") String nice,

			HttpSession session
			) {
		System.out.println("form submitted!!!!");
		

		session.setAttribute("pick_any", pick_any);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("activity", activity);
		session.setAttribute("living", living);
		session.setAttribute("nice",nice);
		

		
		return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String showDetails() {
		
		
		return "details.jsp";
	}
	
}
