package com.belmar.savetravels.models;

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
@Table(name = "expenses")
public class ExpenseItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//expense name
	@NotNull
	@Size(min=1, max=500, message = "Expense item name must be between 1-30 characters")
	private String expenseName; // this will create a field in our table called "expenseName"
		
	//vendor name
	@NotNull
	@Size(min=1, max=500, message = "Vendor name must be between 1-30 characters")
	private String vendorName; // this will create a field in our table called "vendorName"
	
	//amount
	@NotNull
	@Min(value = 1, message = "Expense amount must be atleast $1")
	private double amount;
	
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
	public ExpenseItem() {
		
	}
	
	
	//loaded constructor
	public ExpenseItem(
		String expenseName,
		String vendorName,
		double amount,
		String description) {
		super();
		this.expenseName = expenseName;
		this.vendorName = vendorName;
		this.amount = amount;
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

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getExpenseName() {
		return expenseName;
	}


	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}


	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
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
