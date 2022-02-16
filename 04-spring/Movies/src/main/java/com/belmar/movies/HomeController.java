package com.belmar.movies;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class HomeController {
	@RequestMapping ("/")
	public String helloWorld(Model model) {
		
		String movieTitle = "Gladiator";
		String releaseDate = "2007-03-01";
		String imageUrl = "https://i.guim.co.uk/img/media/29f68aab161f29d8f086e5539c168a3c8379d09f/0_115_2727_1636/master/2727.jpg?width=465&quality=45&auto=format&fit=max&dpr=2&s=90687555f7ac41bf9872e100f2b22897";
		
		
		model.addAttribute("movie",movieTitle);
		model.addAttribute("rd",releaseDate);
		model.addAttribute("imageurl",imageUrl);
		return "index.jsp";	
		}
	
	
	
	
}
