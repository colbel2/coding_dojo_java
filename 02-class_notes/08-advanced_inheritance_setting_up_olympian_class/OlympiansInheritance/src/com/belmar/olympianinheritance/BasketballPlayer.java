package com.belmar.olympianinheritance;

public class BasketballPlayer extends Olympian{
	private int jumpHeight;
	

	public BasketballPlayer() {
		this.energyLevel = 300;
		
	}	
	
	public BasketballPlayer(String nameInput, String countryInput, int jumpHeightInput) {
	
		super(nameInput, countryInput);
		
		this.jumpHeight = jumpHeightInput;
		this.energyLevel = 300;
	}

	public int getJumpHeight() {
		return jumpHeight;
	}

	public void setJumpHeight(int jumpHeight) {
		this.jumpHeight = jumpHeight;
	}
	
	public void dunkBall() {
		System.out.println("He slamdunked!");
		this.energyLevel-=1;
	}
	
	
}
	
