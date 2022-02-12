package com.belmar.cafebusinesslogic;

import java.util.ArrayList;
import java.util.Scanner;

public class CafeUtil {
	public void testing() {
		
		System.out.println("Testing connection to TestCafe.java flile");
		
	}
	
	public int getStreakGoal(int numWeeks) {
		int total = 0;
		
		for(int i = 1; i<=numWeeks; i++) {
//			System.out.println(i);
			total += i;
		}
		return total;
	}
	
	public double getOrderTotal(double[] prices) {
		double total = 0;
		
		for(double itemPrice : prices) {
			total += itemPrice;
		}
		
		return total;
	}
	
	public void displayMenu(ArrayList<String> menuItems) {
		for(int i = 0; i< menuItems.size(); i++) {

			System.out.println(String.format("%s %s",i,menuItems.get(i)));
		}
	}
	public void addCustomer(ArrayList<String> customers) {
		System.out.println("Enter Customer Name:");
//		String userName = System.console().readLine();
		Scanner scan = new Scanner(System.in);
		String userInput = scan.next();
		customers.add(userInput);
	}
}
