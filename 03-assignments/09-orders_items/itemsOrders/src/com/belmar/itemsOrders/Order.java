package com.belmar.itemsOrders;

import java.util.ArrayList;

public class Order {
	
	public String name;
	public Double total;
	public boolean ready;
	
	public ArrayList<Item> items = new ArrayList<Item>();
}
