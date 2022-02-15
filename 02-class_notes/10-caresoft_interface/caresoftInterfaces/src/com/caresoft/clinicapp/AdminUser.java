package com.caresoft.clinicapp;
//... imports class definition...
import java.util.ArrayList;
import java.util.Date;
   // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	

    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(int id, String role) {
		this.id = id;
		this.role = role;
	}
    
    public AdminUser() {
    	
    }
 
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    
	public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    
    
    		// TO DO: Setters & Getters
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		//Pin must be 6 digits or more; returns false if not.Expected to assign the pin to the user (as a member variable)
		int lengthOfPin=String.valueOf(pin).length();
		if(lengthOfPin ==6) {
			this.pin= pin;
			return true;
		}else {
			return false;
		}}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		//Compares the ids, and if they are not a match,creates an incident report using the  authIncident method, Returns true if ids match, false if not.
		if (this.id != confirmedAuthID) {
			this.authIncident();
			return false;
		}else {
		return true;}
	}
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return this.securityIncidents;
	}
}
