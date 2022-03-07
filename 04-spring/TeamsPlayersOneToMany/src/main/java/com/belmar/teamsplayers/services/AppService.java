package com.belmar.teamsplayers.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belmar.teamsplayers.models.Player;
import com.belmar.teamsplayers.models.Team;
import com.belmar.teamsplayers.repository.Playerrepo;
import com.belmar.teamsplayers.repository.TeamRepo;

@Service
public class AppService {
	
	private final TeamRepo teamRepo;
	private final Playerrepo playerRepo;
	public AppService(TeamRepo teamRepo, Playerrepo playerRepo) {
		//super(); this is not needed
		this.teamRepo = teamRepo;
		this.playerRepo = playerRepo;
	}
	
	//create a team 
	public Team createTeam(Team team) {
		return this.teamRepo.save(team);
	}
	
	//GET ALL THE TEAMS
	public List<Team> getAllTeams(){
		return (List<Team>)this.teamRepo.findAll();
	}
	
	
	//create a player
	public Player createPlayer(Player p) {
		return this.playerRepo.save(p);
	}
	
	//get one team by id
	public Team getOneTeam(Long id) {
		return this.teamRepo.findById(id).orElse(null);
	}
	
	
}
