package com.belmar.savetravels.controllers;

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


import com.belmar.savetravels.models.ExpenseItem;
import com.belmar.savetravels.services.ExpenseServices;

@Controller
public class ExpenseItemController {
	private final ExpenseServices expenseServices;

	
	//constructor
	public ExpenseItemController(ExpenseServices expenseServices) {
	
		this.expenseServices = expenseServices;
	}
	
	// all expense items
	@RequestMapping("/expenseitems")
	public String index(Model model) {
		System.out.println(this.expenseServices.allExpenseItems());
		List <ExpenseItem> allExpenseItems=this.expenseServices.allExpenseItems();
		model.addAttribute("allExpenseItems", allExpenseItems);
		
		model.addAttribute("expenseitem",new ExpenseItem());
		return "index.jsp";
	}
	
	//create expense item
	@PostMapping("/expenseitem/create")
	public String create(@Valid @ModelAttribute("expenseitem") ExpenseItem expenseItem, BindingResult result, Model model) {
		if(result.hasErrors()) {
			//need to pass in all menu items again
			List<ExpenseItem> allExpenseItems = this.expenseServices.allExpenseItems();
			
			model.addAttribute("allExpenseItems", allExpenseItems);
			return "index.jsp";
		}else {
			this.expenseServices.createExpenseItem(expenseItem);
			return "redirect:/expenseitems";
		}	
	}
	
	
	//get info about one menu item by ID
		@RequestMapping("/expenseitems/{id}")
		public String show(@PathVariable("id") Long id, Model model) {
			ExpenseItem expenseItem = this.expenseServices.findExpenseItem(id);
			
			model.addAttribute("expenseItem", expenseItem);
			return "oneItem.jsp";
		}
		
		//edit one item
		@RequestMapping("/expenseitems/edit/{id}")
		public String edit(@PathVariable("id") Long id, Model model) {
			//get info about the menu item i want to edit by using the id in the route path so I can pre-populate the edit form with this menu item's info. 
			ExpenseItem itemToEdit = this.expenseServices.findExpenseItem(id);
			
			model.addAttribute("itemToEdit", itemToEdit);
			
			return "edit.jsp";
		}
		@PutMapping("/expenseitems/update/{id}")
		public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("itemToEdit") ExpenseItem expenseItemToEdit, BindingResult result, Model model) {
			if(result.hasErrors()) {
				
				return "edit.jsp";
			}else {
				
				this.expenseServices.updateItem(expenseItemToEdit);
				return "redirect:/expenseitems";
			}
			
		}
	
}
	