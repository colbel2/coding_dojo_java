package com.belmar.onemorerep.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="workouts")
public class Workout {
	//primary key for id thats auto generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//name of Workout
	@NotEmpty(message="Name of Workout must not be empty. Examples: Back, Chest, Legs, etc...")
	@Size(min=2,max=100, message="Name must be atleast 2 characters and no more than 100!")
	private String workoutName;
	
		

		
		
	
		
	//diary entry
	@NotEmpty(message="Diary entry is required!")
	@Size(min=10, message="Description must be at least 10 characters long")
	private String diary;
	
	
	
	
//user who uploaded the workout
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="uploader_id")
	private User uploader;
	
	
//one to many with exercise
	@OneToMany(mappedBy="exerciser", fetch = FetchType.LAZY)
    private List<Exercise> exercises;
	
	
		
//created at and updated at time stamps
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	    
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	 }
	    
	    
	//empty constructor
	public Workout(){}
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id= id;
	}
	public String getWorkoutName() {
		return workoutName;
	}
	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}
	public User getUploader() {
		return uploader;
	}
	public void setUploader(User uploader) {
		this.uploader = uploader;
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
	
	public String getDiary() {
		return diary;
	}
	public void setDiary(String diary) {
		this.diary = diary;
	}
	public List<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	
	    
	
	    
	    
}
