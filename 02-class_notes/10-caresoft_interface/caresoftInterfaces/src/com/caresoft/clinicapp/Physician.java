package com.caresoft.clinicapp;


//... imports class definition...    
import java.util.Date;
import java.util.ArrayList;
// TO DO: Implement HIPAACompliantUser!
public class Physician extends User implements HIPAACompliantUser {
		 // TO DO: Constructor that takes an ID
    public  Physician(Integer id) {
    	this.id = id;
    }
    
    
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		//Pin must be exactly 4 digits, returns false if not. Expected to assign the pin to the user (as a member variable)
		int lengthOfPin=String.valueOf(pin).length();
		if(lengthOfPin ==4) {
			this.pin= pin;
			return true;
			
		}else {
		return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		//Checks the physician's id against the given id; returns true if they are a match, otherwise false.
		if(this.id == confirmedAuthID) {
			return true;
		}else {
		return false;
		}
	}
	

		// Inside class:    
    private ArrayList<String> patientNotes;
		
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
    
    
    	// TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
   
    
    
}
