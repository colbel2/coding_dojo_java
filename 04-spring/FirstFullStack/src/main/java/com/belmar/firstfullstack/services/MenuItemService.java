package com.belmar.firstfullstack.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belmar.firstfullstack.models.MenuItem;
import com.belmar.firstfullstack.repo.MenuItemRepo;

@Service
public class MenuItemService {

	//adding the menu repo as a dependency
	private final MenuItemRepo menuRepo;
	
	//constructor that has the repo injected into it
	public MenuItemService(MenuItemRepo menuRepo) {
		this.menuRepo = menuRepo;
	}
	
	//methods that can use the repo to talk to the db
	//returns all Menu Items
	public List<MenuItem> allMenuItems(){
		return (List<MenuItem>)this.menuRepo.findAll();
	}
	
	public MenuItem createMenuItem(MenuItem menuItem) {
		return this.menuRepo.save(menuItem);
	}
	
	public MenuItem findMenuItem(Long id) {
		return this.menuRepo.findById(id).orElse(null);
	}
}
