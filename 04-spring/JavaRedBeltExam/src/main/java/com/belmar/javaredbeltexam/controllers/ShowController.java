package com.belmar.javaredbeltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.belmar.javaredbeltexam.models.Show;
import com.belmar.javaredbeltexam.services.ShowService;

@Controller
public class ShowController {

	@Autowired
    private ShowService showServ;
	
	
	@RequestMapping("/shows/new")
	public String addNewShow(Model model, HttpSession session) {
		//we will render a create form in this method
		
		
		//pass in empty idea object to the form so the form can bind to it
		model.addAttribute("show", new Show());
		 
		
//		get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the item/idea/pet/etc;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		
		return "addShow.jsp";
	}
	
	@PostMapping("/shows/create")
	public String createNewShow(@Valid @ModelAttribute("show") Show show, BindingResult result) {
		if(result.hasErrors()) {
			return "addShow.jsp";
		}
		
		//if the form is submitted properly and there are no validation errors, request the service to create something new( new idea)
		this.showServ.createNewShow(show);
		
		return "redirect:/home";
	}
	
	
	@RequestMapping("/shows/{id}/details")
	public String getShowDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		//use the id from the path variable to send to the service to get info about a show given that id
		Show showToShow = this.showServ.getOneShow(id);
		
		model.addAttribute("showToShow", showToShow);
		
//		get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the item/idea/pet/etc;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		
		return "showDetail.jsp";
	}
	
	@RequestMapping("/shows/{id}/edit")
	public String editShow(@PathVariable("id")Long id, Model model, HttpSession session) {
		
		//get an idea from the db using the service and the id from the path
		Show show = this.showServ.getOneShow(id);
		
		model.addAttribute("show", show);
		
		
		//get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the item/idea/pet/etc;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		
			return "editShow.jsp";
		
		
		
		
	}
	
	@PutMapping("/shows/{id}/update")
	public String updateIdea(@PathVariable("id") Long id, @Valid @ModelAttribute("show") Show show, BindingResult result) {
		
		if(result.hasErrors()) {
			return "editShow.jsp";
		}
		
		//if no validation errors, send the idea object from the from to the service so the service can update it
		this.showServ.updateShow(show);
		return "redirect:/home";
		
	}
	
	@RequestMapping("/shows/{id}/delete")
    public String deleteShow(@PathVariable("id") Long id) {
		
		this.showServ.deleteShow(id);
		
		return "redirect:/home";
	}
	
	
	
	
	
	
}