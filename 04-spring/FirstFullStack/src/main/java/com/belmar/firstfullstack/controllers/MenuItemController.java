package com.belmar.firstfullstack.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.belmar.firstfullstack.models.MenuItem;
import com.belmar.firstfullstack.services.MenuItemService;
@Controller
public class MenuItemController {
	private final MenuItemService menuService;
	
	//constructor
	public MenuItemController(MenuItemService menuService) {
		this.menuService = menuService;
	}
	
	//all menu items
	@RequestMapping("/menuitems")
	public String index(Model model){
		System.out.println(this.menuService.allMenuItems());
		
		List<MenuItem> allMenuItems=this.menuService.allMenuItems();
		model.addAttribute("allMenuItems", allMenuItems); 
		return "index.jsp";
	}
	
	
}
