package com.belmar.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
}
	