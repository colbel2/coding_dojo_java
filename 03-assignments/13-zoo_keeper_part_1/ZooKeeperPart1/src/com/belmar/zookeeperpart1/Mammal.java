package com.belmar.zookeeperpart1;

public class Mammal {

	public int energyLevel=100;
	
	
	//display energy
	public void displayEnergy() {
		System.out.println("Energy Level: " + this.energyLevel);
	}
	
	public void decreaseEnergy() {
		energyLevel -= 5;
	}
	
	public void increaseEnergy() {
		energyLevel += 10;
	}
}
