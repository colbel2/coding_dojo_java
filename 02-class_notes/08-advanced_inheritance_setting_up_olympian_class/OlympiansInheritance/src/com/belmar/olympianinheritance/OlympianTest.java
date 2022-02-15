package com.belmar.olympianinheritance;

public class OlympianTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello World Test");
		
		
		Olympian olympian1 = new Olympian();
//		Olympian olympian2 = new Olympian("Phelps", "USA");
//		
		System.out.println(olympian1.getName());
//		System.out.println(olympian2.getName());
//		
//		olympian1.displayCountry();
//		olympian2.displayCountry();
//		
//		olympian1.displayEnergy();
//		olympian2.displayEnergy();
		
		
		//Swimmers Below inherited from Olympian
		Swimmer swimmer1 = new Swimmer();
		Swimmer swimmer2 = new Swimmer("Phelps", "USA", 200);
		System.out.println(swimmer1.getName());
		System.out.println(swimmer1.getCountry());
		System.out.println(swimmer1.getEnergyLevel());
		System.out.println(swimmer1.getSwimSpeed());
		
		System.out.println("Swimmer 2 info below: ");
		System.out.println(swimmer2.getName());
		System.out.println(swimmer2.getCountry());
		System.out.println(swimmer2.getEnergyLevel());
		System.out.println(swimmer2.getSwimSpeed());
		
		
		BasketballPlayer baller1 = new BasketballPlayer("Michael","USA", 50);
		System.out.println("Basketball info below");
		System.out.println(baller1.getName());
		System.out.println(baller1.getCountry());
		System.out.println(baller1.getEnergyLevel());
		System.out.println(baller1.getJumpHeight());
		baller1.dunkBall();
		System.out.println(baller1.getEnergyLevel());
		
		
	
	
	}

}
