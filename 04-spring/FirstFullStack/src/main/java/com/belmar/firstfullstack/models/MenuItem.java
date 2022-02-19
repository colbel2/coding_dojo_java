package com.belmar.firstfullstack.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")//this is the name of the table. Name it plural and all lowercase.

public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//name
	@NotNull
	@Size(min=2, max=30, message = "Menu item name must be between 2-30 characters")
	private String name; // this will create a field in our table called "name"
	
	
	
	//dishtype (appetizer, drink, main dish, etc...)
	@NotNull
	@Size(min=2, max=30, message = "Menu item dish must be between 2-30 characters")
	private String dishType;
	
	//price
	@NotNull
	@Min(value = 1, message = "Price must be atleast $1.")
	private double price;
	
	//description
	@NotNull
	@Size(min=5, max=100, message = "Menu Description must be between 5 - 100 characters")
	private String description;
	
	//This will allow the createdAt column to be updated after creation
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	//empty constructor
	public MenuItem() {
		
	}
	
	
	//loaded constructor
	public MenuItem(
		String name,
		String dishType,
		double price,
		String description){
		super();
		this.name = name;
		this.dishType = dishType;
		this.price = price;
		this.description = description;
		}
	//other getters and setters for brevity
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}

	// Getters and setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDishType() {
		return dishType;
	}


	public void setDishType(String dishType) {
		this.dishType = dishType;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
		
	
	
	
	
		
	
}
