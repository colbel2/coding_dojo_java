package com.belmar.olympianinheritance;

public class Swimmer extends Olympian{
	
	
	//member variable - lung capacity
	private int swimSpeed=100;
	
	
	//empty constructor
	public Swimmer() {
		this.energyLevel=500;
	}
	
	//loaded constructor
	public Swimmer(String nameInput, String countryInput, int swimSpeedInput) {
		super(nameInput, countryInput);
		
		this.swimSpeed = swimSpeedInput;
		this.energyLevel = 500;
	}
	
	

	public int getSwimSpeed() {
		return swimSpeed;
	}

	public void setSwimSpeed(int swimSpeed) {
		this.swimSpeed = swimSpeed;
	}
	
	public void swim() {
		
		
	}
}
