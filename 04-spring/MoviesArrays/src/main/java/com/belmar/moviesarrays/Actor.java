package com.belmar.moviesarrays;




public class Actor {
	private String firstName;
	private String lastName;
	private int age;
	
	
	public Actor() {
		
	}
	
	public Actor(String firstNameInput, String lastNameInput, int ageInput) {
		this.firstName = firstNameInput;
		this.lastName = lastNameInput;
		this.age = ageInput;
	}

	
	//getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
