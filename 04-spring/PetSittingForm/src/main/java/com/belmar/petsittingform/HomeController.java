package com.belmar.petsittingform;

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
	
//	@RequestMapping(value= "/process_appointment", method=RequestMethod.POST) //you can do it this way, but its more typing
	@PostMapping("/process_appointment")
	public String process(
			@RequestParam("pet_name") String pet_name,
			@RequestParam("age") Integer age,
			@RequestParam("owner_name") String owner_name,
			@RequestParam("activity") String activity,
			@RequestParam("away") String away,
//			@RequestParam Map<String,String> allRequestParams, //this is the shortcut way of doing the above 5 lines of code...only do this.
			HttpSession session
			) {
		System.out.println("form submitted!!!!");
		
//		print(request.form("pet_name")) //in python you would print info from the form like this
//		System.out.println(pet_name);
//		System.out.println(fav_activity);
		session.setAttribute("pname", pet_name);
		session.setAttribute("age", age);
		session.setAttribute("owner_name", owner_name);
		session.setAttribute("activity", activity);
		session.setAttribute("away", away);
		
//		System.out.println(allRequestParams.get("other_animals"));
		
		return "redirect:/details";
	}
	
	@RequestMapping("/details")
	public String showDetails() {
		
		
		return "details.jsp";
	}
	
}