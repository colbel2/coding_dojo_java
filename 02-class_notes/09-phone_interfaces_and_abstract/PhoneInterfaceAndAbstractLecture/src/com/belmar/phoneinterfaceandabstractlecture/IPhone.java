package com.belmar.phoneinterfaceandabstractlecture;

public class IPhone extends Phone implements Ringable{

	
	//constructor
		public IPhone(String versionNumberInput, int batteryLifeInput, String carrierInput, String ringtoneInput) {
			
			super(versionNumberInput, batteryLifeInput, carrierInput, ringtoneInput);
		}
		
		public void displayInfo(){
			this.getVersionNumber();
			System.out.println("iPhone is displaying info:");
			System.out.println(String.format("iPhone Info: \n Version Number: %s \n Battery Life: %s \n Carrier: %s \n Ringtone: %s",this.getVersionNumber(), this.getBatteryLife(),this.getCarrier(),this.getRingtone()));
		}
		
		
		public void ring() {
			
		}
		
		public void unlockPhone() {
			
		}
}
