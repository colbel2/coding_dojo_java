package com.belmar.javaredbeltexam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//book name
	@NotBlank
	@Size(min=2, max=50, message = "Book name must be between 3-50 characters")
	private String bookName; // this will create a field in our table called "bookName"
	
	//Author name
	@NotBlank
	@Size(min=2, max=50, message = "Last name must be between 3-50 characters")
	private String authorName; // this will create a field in our table called "authorName"
	
	
	@NotBlank
	@Size(min=2, max=500, message = "Description must be between 3-500 characters")
	private String description; // this will create a field in our table called "postedName"k
	
	
	//This will allow the createdAt column to be updated after creation
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
		
	//other getters and setters for brevity
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}	
		
	//empty constructor
	public Book() {
		
	}
	
	
	//loaded constructor
	public Book(String bookName, String authorName, String description, User postedBy) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.postedBy = postedBy;
	}
	
	//MANY TO ONE CODE BELOW
	
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="loggedInUserID")
		private User postedBy;

		
		//getters and setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
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
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public User getPostedBy() {
			return postedBy;
		}
		public void setPostedBy(User postedBy) {
			this.postedBy = postedBy;
		}
	
	
	
}
