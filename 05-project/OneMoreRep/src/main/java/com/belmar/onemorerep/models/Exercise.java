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
@Table(name="exercises")
public class Exercise {

	//primary key for id thats auto generated
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
	//name of exercise
		@NotEmpty(message="Name of Exercise must not be empty.")
		@Size(min=2,max=250,message="Name must be between 2 and 250 characters.")
		private String exerciseName;
		
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
		
		
		
//many to one with workout
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="exerciser_id")
		private Workout exerciser;
		
//one to many with sets
	@OneToMany(mappedBy="exerciseInformer",fetch = FetchType.LAZY)
	private List<ExerciseInfo> exerciseInfos;
	
	
	
	//empty constructor
	public Exercise() {}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
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
	
	
	public void setExerciser(Workout exeriser) {
		this.exerciser = exeriser;
	}
	
	public Workout getExerciser() {
		return exerciser;
	}
	public List<ExerciseInfo> getExerciseInfos() {
		return exerciseInfos;
	}
	public void setExerciseInfos(List<ExerciseInfo> exerciseInfos) {
		this.exerciseInfos = exerciseInfos;
	}
	
	
	
	
	
}
