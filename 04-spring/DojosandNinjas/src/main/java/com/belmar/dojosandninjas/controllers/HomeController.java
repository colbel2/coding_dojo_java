package com.belmar.dojosandninjas.controllers;





import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.belmar.dojosandninjas.models.Dojo;
import com.belmar.dojosandninjas.models.Ninja;
import com.belmar.dojosandninjas.services.AppService;


@Controller
public class HomeController {
	private final AppService appService;
	public HomeController(AppService appService) {
		this.appService = appService;
	}
	
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("dojo", new Dojo());
		return "dojohome.jsp";
	}
	
	//create dojo
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojohome.jsp";
		}else {
			this.appService.createDojo(dojo);
		}
		return "redirect:/";
	}
	
	//add a ninja
	@RequestMapping("/ninja/add")
	public String addNinja(Model model) {
		model.addAttribute("ninja",new Ninja());
		
		model.addAttribute("alldojos",this.appService.getAllDojos());
		return "addninja.jsp";
		}
	
	//create a ninja when the from is submitted
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "addninja.jsp";
		}else {
			this.appService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String showOneDojoDetails(@PathVariable("id")Long id, Model model){
		
		Dojo dojoToShow = this.appService.getOneDojo(id);
		model.addAttribute("dojoToShow",dojoToShow);
		return "oneDojoDetails.jsp";
	}
	
	
}
