package com.belmar.onemorerep.models;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="exerciseInfos")
public class ExerciseInfo {
	//primary key for id thats auto generated
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
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
		
		//set1
		@NotNull
		@Min(value=1,message="Must be atlest 1 set")
		private Double numberOfSets;
		
		
		
		
		//reps
		@NotNull
		@Min(value=1, message= "Must complet atleast 1 rep.")
		private Double rep;
			
		//weight used, if any
			
		private String weight;
		
		//many to one with exercies
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="exerciseInformer_id")
		private Exercise exerciseInformer;
		
	//empty constructor
		public ExerciseInfo() {}
		
		//getters and setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
	
		public Double getRep() {
			return rep;
		}
		public void setRep(Double rep) {
			this.rep = rep;
		}
		public String getWeight() {
			return weight;
		}
		public void setWeight(String weight) {
			this.weight = weight;
		}
		public Exercise getExerciseInformer() {
			return exerciseInformer;
		}
		public void setExerciseInformer(Exercise exerciseInformer) {
			this.exerciseInformer = exerciseInformer;
		}
		public Double getNumberOfSets() {
			return numberOfSets;
		}
		public void setNumberOfSets(Double numberOfSets) {
			this.numberOfSets = numberOfSets;
		}
		
	
		
		
		
		
		
		
		
}
