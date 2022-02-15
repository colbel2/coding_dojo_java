package com.belmar.phoneinterfaceandabstractlecture;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello World"); tested and we are connected
		
		
		//phone instances
//		Phone phone1 = new Phone("S21",69, "Verizon", "Silent");
		Galaxy galaxy1 = new Galaxy("S21",69, "Verizon", "Silent");
		IPhone iPhone1 = new IPhone("6",3,"Cricket", "Buzzer");
		
		
		
		
		
		//testing outputs below
		galaxy1.displayInfo();
		iPhone1.displayInfo();
		galaxy1.ring();
		galaxy1.unlockPhone();
		
		
	}

}
