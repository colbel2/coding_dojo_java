package com.belmar.OOPintroStocks_Portfolio;

public class PortfolioStockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello OOP Intro: TEST");
//		System.out.println("Testing from VSCODE");
		
		
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
		Stock stock3 = new Stock();
		
		stock1.name = "MARA";
		stock2.name = "Apple";
		stock3.name = "Novavax";
		
		stock1.price = 24.87;
		stock2.price = 17.43;
		stock3.price = 99.21;
		
//		System.out.println(stock1.name);
//		System.out.println(String.format("Stock 1 info: Name %s. Price: %s",stock1.name,stock1.price));
		
		Portfolio portfolio1 = new Portfolio();
		Portfolio portfolio2 = new Portfolio();
		
		portfolio1.name = "Rora";
		portfolio1.totalBalance = 100;
		portfolio1.isDiamondHands = false;
		portfolio1.stocks.add(stock1);
		portfolio1.stocks.add(stock2);
		portfolio2.name = "Lexi";
		portfolio2.totalBalance = 2000;
		
		System.out.println(String.format("Portfolio info: Owner: %s, Balance: %s, Stocks: %s, ",portfolio1.name, portfolio1.totalBalance, portfolio1.stocks ));
		
		
	}

}
