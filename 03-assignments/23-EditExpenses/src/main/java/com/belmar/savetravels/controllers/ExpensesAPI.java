package com.belmar.savetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.belmar.savetravels.models.ExpenseItem;
import com.belmar.savetravels.services.ExpenseServices;

@RestController
public class ExpensesAPI {
	private final ExpenseServices expenseServices;
	
	//constructor
	public ExpensesAPI(ExpenseServices expenseServices) {
		this.expenseServices = expenseServices;
	}
	
	//all expense items
	@RequestMapping("/api/expenseitems")
	public List<ExpenseItem> index(){
		return this.expenseServices.allExpenseItems();
	}
	
	//create expense items
	@PostMapping("/api/expenseitems")
	public ExpenseItem create(
			@RequestParam(value = "expenseName") String expenseName, 
			@RequestParam(value = "vendorName") String vendorName, 
			@RequestParam(value = "amount") double amount,
			@RequestParam(value = "description") String description
			) {
		ExpenseItem newItem = new ExpenseItem(expenseName, vendorName, amount, description);
		return this.expenseServices.createExpenseItem(newItem);
		
	}
	
	//find one item
		@RequestMapping("/api/expenseitems/{id}")
		public ExpenseItem show(@PathVariable("id") Long id) {
			ExpenseItem expenseItemToShow = this.expenseServices.findExpenseItem(id);
			return expenseItemToShow;
		}
	
	
}
