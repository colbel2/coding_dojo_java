package com.belmar.phoneinterfaceandabstractlecture;

public abstract class Phone {

	
	//member variables aka attributes, fields
	
	//versionNumber
	private String versionNumber;
	
	//batteryLife
	private int batteryLife;
	
	//carrier
	private String carrier;
	
	//ringtone
	private String ringtone;
	
	
	//empty construtor
	public Phone() {
		
	}
	
	
	//constructor
	public Phone(String versionNumberInput, int batteryLifeInput, String carrierInput, String ringtoneInput) {
		this.versionNumber = versionNumberInput;
		this.batteryLife = batteryLifeInput;
		this.carrier = carrierInput;
		this.ringtone = ringtoneInput;
	}
	
	
	
	//abstract method
	public abstract void displayInfo();

	
	
	
	//getters and setters
	public String getVersionNumber() {
		return versionNumber;
	}


	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}


	public int getBatteryLife() {
		return batteryLife;
	}


	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}


	public String getCarrier() {
		return carrier;
	}


	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}


	public String getRingtone() {
		return ringtone;
	}


	public void setRingtone(String ringtone) {
		this.ringtone = ringtone;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
