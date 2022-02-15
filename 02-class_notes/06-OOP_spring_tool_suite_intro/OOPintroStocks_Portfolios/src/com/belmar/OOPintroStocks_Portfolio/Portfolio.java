package com.belmar.OOPintroStocks_Portfolio;

import java.util.ArrayList;

public class Portfolio {
	
	//static variables are referenced from the class level. Instance does not need to be made to access the method
//	public static int numberOfAccountsCreated = 0;
	private static int numberOfAccountsCreated = 0;

	//empty constructor
	public Portfolio() {
		this.name = "Guest User";
		numberOfAccountsCreated++;
	}
	
	//loaded constructor
	public Portfolio(String nameInput) {
		this.name = nameInput;
		numberOfAccountsCreated++;
		
	}
	
	//name of owner
	private String name;
	
	//totalBalance
	private double totalBalance;
	
	//isDiamondHands
	private boolean isDiamondHands;
	
	//list of stocks
	private ArrayList<Stock> stocks = new ArrayList<Stock>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalBalance() {
		System.out.println(totalBalance);
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public boolean isDiamondHands() {
		return isDiamondHands;
	}

	public void setDiamondHands(boolean isDiamondHands) {
		this.isDiamondHands = isDiamondHands;
	}

	public ArrayList<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(ArrayList<Stock> stocks) {
		for(Stock stock: stocks) {
			this.totalBalance+=stock.getPrice();
		}
		
		
		this.stocks = stocks;
		
	}
	
	public void addOneStock(Stock stockObj) {
		this.stocks.add(stockObj);
		this.totalBalance += stockObj.getPrice();
	}
	
	public void printRiskAssessment() {
		if(this.isDiamondHands) {
			System.out.println("Im not selling");
			
		}else {
			System.out.println("I sold");
		}
	}
	
	public void displayInfo() {
		String info = String.format("Name: %s \n Total Balance: %s \n", this.name, this.totalBalance);
		
		String stocksInfo = "";
		for (int i =0; i<this.stocks.size(); i++) {
			stocksInfo += String.format("%s - Price: %s \n",this.name, this.stocks.get(i).getPrice());
		}
		// looping thru the stocks
			System.out.println(stocksInfo);
			System.out.println(info);
	}
	
	public static int getNumberOfAccountsCreated() {
		return numberOfAccountsCreated;
	}

	public static void setNumberOfAccountsCreated(int numberOfAccountsCreated) {
		Portfolio.numberOfAccountsCreated = numberOfAccountsCreated;
	}
	
	
}
