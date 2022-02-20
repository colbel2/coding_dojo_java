package com.belmar.savetravels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belmar.savetravels.models.ExpenseItem;
import com.belmar.savetravels.repo.ExpenseItemRepo;

@Service
public class ExpenseServices {
	private final ExpenseItemRepo expenseRepo;
	
	
	public ExpenseServices(ExpenseItemRepo expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	//returns all expense items
	
	public List<ExpenseItem> allExpenseItems() {
		return (List<ExpenseItem>)this.expenseRepo.findAll();
	}
	
	//create an expense item
	public ExpenseItem createExpenseItem(ExpenseItem expenseItem) {
		return this.expenseRepo.save(expenseItem);
	}
	
}
