package com.belmar.OOPintroStocks_Portfolio;

import java.util.ArrayList;

public class PortfolioStockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello OOP Intro: TEST");
//		System.out.println("Testing from VSCODE");
		
		
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
		Stock stock3 = new Stock();
		Stock stock4 = new Stock("Jeep", 54.25);
		
		stock1.setName("Mara");
//		stock2.name = "Apple";
//		stock3.name = "Novavax";
		stock2.setName("Apple");
		stock3.setName("Novavax");
				
		
//		stock1.price = 24.87;
//		stock2.price = 17.43;
//		stock3.price = 99.21;
		stock1.setPrice(24.87);
		stock2.setPrice(17.43);
		stock3.setPrice(99.21);
		
		
//		System.out.println(stock4.getName());
//		System.out.println(stock1.getName());
		System.out.println(String.format("Stock 1 info: Name %s. Price: %s",stock1.getName(),stock1.getPrice()));
		
		Portfolio portfolio1 = new Portfolio();
		Portfolio portfolio2 = new Portfolio("Alexis");
		Portfolio portfolio3 = new Portfolio();
//		Portfolio.numberOfAccountsCreated;
		
		portfolio1.setName("Rora");
		portfolio1.setTotalBalance(100.00);
		portfolio1.setDiamondHands(false);
//		portfolio1.stocks.add(stock1);
//		portfolio1.stocks.add(stock2);
		
		ArrayList<Stock> roraStocks = new ArrayList<Stock>();
		roraStocks.add(stock1);
		roraStocks.add(stock2);
		portfolio1.setStocks(roraStocks);
//		portfolio2.setName("Lexi");
//		portfolio2.setTotalBalance(2000);
		
//		System.out.println(String.format("Portfolio info: Owner: %s, Balance: %s, Stocks: %s, ",portfolio1.getName(), portfolio1.getTotalBalance(), portfolio1.getStocks()));
		
		portfolio1.addOneStock(stock4);
//		System.out.println(portfolio1.getStocks());
//		portfolio1.printRiskAssessment();
//		portfolio1.getTotalBalance();
		
		portfolio1.displayInfo();
		
		System.out.println(Portfolio.getNumberOfAccountsCreated());
	}

}
