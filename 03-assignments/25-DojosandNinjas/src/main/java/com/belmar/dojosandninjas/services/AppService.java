package com.belmar.dojosandninjas.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.belmar.dojosandninjas.models.Dojo;
import com.belmar.dojosandninjas.models.Ninja;
import com.belmar.dojosandninjas.repos.DojoRepo;
import com.belmar.dojosandninjas.repos.NinjaRepo;

@Service
public class AppService {

	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	public AppService(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	//create a dojo
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	//get all dojos
	public List<Dojo> getAllDojos(){
		return (List<Dojo>)this.dojoRepo.findAll();
	}
	
	//create a ninja
	public Ninja createNinja(Ninja n) {
		return this.ninjaRepo.save(n);
	}
	
	//get one dojo by id
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
	
	
}
