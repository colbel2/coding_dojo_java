package com.belmar.fullstackrestaurant;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
//	@PostMapping("/process_appointment")
//	public String process(
//			@RequestParam("pet_name") String pet_name,
//			HttpSession session
//			) {
		//System.out.println("form submitted!!!!");
		

		//session.setAttribute("pname", pet_name);
		
		

		
		//return "redirect:/";
	}
	
