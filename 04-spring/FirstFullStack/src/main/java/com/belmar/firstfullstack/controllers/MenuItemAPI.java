package com.belmar.firstfullstack.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.belmar.firstfullstack.models.MenuItem;
import com.belmar.firstfullstack.services.MenuItemService;

@RestController//raw data
public class MenuItemAPI {
	private final MenuItemService menuService;
	
	//constructor
	public MenuItemAPI(MenuItemService menuService) {
		this.menuService = menuService;
	}
	
	//all menu items
	@RequestMapping("/api/menuitems")
	public List<MenuItem> index(){
		
		return this.menuService.allMenuItems();
	}
	
	//create new menu item
	@PostMapping("/api/menuitems")
	public MenuItem create(
			@RequestParam(value = "name") String name, 
			@RequestParam(value = "dishType") String dishType, 
			@RequestParam(value = "price") double price,
			@RequestParam(value = "description") String description
			) {
		MenuItem newItem = new MenuItem(name, dishType, price, description);
		return this.menuService.createMenuItem(newItem);
		
	}
	
	
	//find one item
	@RequestMapping("/api/menuitems/{id}")
	public MenuItem show(@PathVariable("id") Long id) {
		MenuItem menuItemToShow = this.menuService.findMenuItem(id);
		return menuItemToShow;
	}
	
	
	
}
