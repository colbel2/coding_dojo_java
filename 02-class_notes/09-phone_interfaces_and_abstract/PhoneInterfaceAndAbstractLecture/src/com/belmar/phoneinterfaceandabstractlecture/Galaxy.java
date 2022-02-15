package com.belmar.phoneinterfaceandabstractlecture;

public class Galaxy extends Phone implements Ringable{
	
	//constructor
	public Galaxy(String versionNumberInput, int batteryLifeInput, String carrierInput, String ringtoneInput) {
		
		super(versionNumberInput, batteryLifeInput, carrierInput, ringtoneInput);
	}
	
	public void displayInfo(){
		this.getVersionNumber();
		System.out.println("Android is displaying info:");
		System.out.println(String.format("Galaxy Info: \n Version Number: %s \n Battery Life: %s \n Carrier: %s \n Ringtone: %s",this.getVersionNumber(), this.getBatteryLife(),this.getCarrier(),this.getRingtone()));
	}
	
	
	//impmented interface methods defined below from Ringable.java file
	public void ring() {
		System.out.println("Your phone is on silent" + this.getRingtone());
	}
	
	
	public void unlockPhone() {
		System.out.println("Double Tap Screen");
	}
}
