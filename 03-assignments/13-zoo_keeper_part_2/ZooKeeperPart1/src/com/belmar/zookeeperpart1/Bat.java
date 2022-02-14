package com.belmar.zookeeperpart1;

public class Bat extends Mammal{

	public void fly() {
		System.out.println("The bat flew!");
		this.energyLevel-=50;
	}
	
	public void attackTown() {
		System.out.println("Lookout! The bat is attacking!");
		this.energyLevel-=100;
	}
	
	public void eatHumans() {
		System.out.println("The bat ate a human :( ");
		this.energyLevel+=25;
	}
	
	public Bat() {
		this.energyLevel= 500;
	}
	
}
