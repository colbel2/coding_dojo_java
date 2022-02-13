package com.belmar.olympianinheritance;

public class Olympian {
	//name
	private String name;
	//energyLevel
	private int energyLevel=100;
	//country
	private String country;
	
	//constructor
	public Olympian() {
		this.name = "Guest user";
		this.country = "World";
	}
	
	//loaded constructor
	public Olympian(String nameInput, String countryInput) {
		this.name = nameInput;
		this.country = countryInput;
	}
	
	//display energy
	public void displayEnergy() {
		System.out.println("Energy Level: " + this.energyLevel);
	}
	
	//display country
	public void displayCountry() {
		System.out.println("Country: " + this.country);
	}

	
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
