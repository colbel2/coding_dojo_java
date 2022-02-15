package com.belmar.OOPintroStocks_Portfolio;

public class Stock {

	//constructor is a method that lets you define how to initialize a class
	
	public Stock() {
		
	}
	
	//overloading constructor so that we can create (construct) a stock
	public Stock(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	//name
	private String name;
	
	//price
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length() <2) {
			System.out.println("Name must have more than 2 letters.");
		}
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
