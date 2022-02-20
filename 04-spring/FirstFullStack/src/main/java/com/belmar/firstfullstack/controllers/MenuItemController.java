package com.belmar.firstfullstack.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
		model.addAttribute("menuitem", new MenuItem());
		return "index.jsp";
	}
	
	//get info about one menu item by ID
	@RequestMapping("/menuitems/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		MenuItem menuItem = this.menuService.findMenuItem(id);
		
		model.addAttribute("menuItem", menuItem);
		return "oneItem.jsp";
	}
	
	@PostMapping("/menuitem/create")
	public String create(@Valid @ModelAttribute("menuitem") MenuItem menuItem, BindingResult result, Model model) {
		if(result.hasErrors()) {
			//need to pass in all menu items again
			List<MenuItem> allMenuItems = this.menuService.allMenuItems();
			
			model.addAttribute("allMenuItems", allMenuItems);
			return "index.jsp";
		}else {
			this.menuService.createMenuItem(menuItem);
			return "redirect:/menuitems";
		}	
	}
	
	@RequestMapping("/menuitems/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		//get info about the menu item i want to edit by using the id in the route path so I can pre-populate the edit form with this menu item's info. 
		MenuItem itemToEdit = this.menuService.findMenuItem(id);
		
		model.addAttribute("itemToEdit", itemToEdit);
		
		return "edit.jsp";
	}
	
	@PutMapping("/menuitems/update/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("itemToEdit") MenuItem menuItemToEdit, BindingResult result, Model model) {
		if(result.hasErrors()) {
			
			return "edit.jsp";
		}else {
			
			this.menuService.updateItem(menuItemToEdit);
			return "redirect:/menuitems";
		}
		
	}
	
	@RequestMapping("/menuitems/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.menuService.deleteItem(id);
		
		return "redirect:/menuitems";
	}
	
	
}
