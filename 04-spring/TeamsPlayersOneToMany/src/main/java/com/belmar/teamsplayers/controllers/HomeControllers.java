package com.belmar.teamsplayers.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.belmar.teamsplayers.models.Player;
import com.belmar.teamsplayers.models.Team;
import com.belmar.teamsplayers.services.AppService;

@Controller
public class HomeControllers {
	private final AppService appService;
	public HomeControllers(AppService appService) {
		this.appService = appService;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		
		
		model.addAttribute("team", new Team());
		return "teamhome.jsp";
	}
	
	//create team
	@PostMapping("/teams/create")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
		
		if(result.hasErrors()) {
			return "teamhome.jsp";
		}else {
			//if no form errors create team
			this .appService.createTeam(team);
		}
		
		return "redirect:/"; 
	}
	
	//add a player
	@RequestMapping("/player/add")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		
		model.addAttribute("allteams",this.appService.getAllTeams());
		return"addplayer.jsp";
	}
	
	
	//create a player when the form is submitted
	@PostMapping("/player/create")
	public String createPlayer(@Valid @ModelAttribute("player")Player player, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addplayer.jsp";
		}else {
			this.appService.createPlayer(player);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/teams/{id}")
	public String showOneTeamDetails(@PathVariable("id")Long id, Model model) {
		
		Team teamToShow = this.appService.getOneTeam(id);
		
		model.addAttribute("teamToShow", teamToShow);
		return"oneTeamDetails.jsp";
	}
	
	
	
}
