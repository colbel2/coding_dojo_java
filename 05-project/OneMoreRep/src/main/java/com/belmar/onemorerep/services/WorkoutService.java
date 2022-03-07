package com.belmar.onemorerep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belmar.onemorerep.models.Workout;
import com.belmar.onemorerep.repositories.WorkoutRepository;

@Service
public class WorkoutService {

	@Autowired
	private WorkoutRepository workoutRepo;

	
	//show all workouts
	public List<Workout> findAllWorkouts(){
		//use the repo to query the idea table for all Shows
		return (List<Workout>)this.workoutRepo.findAll();
	}
	
	
	//create workout
	public Workout createNewWorkout(Workout workout) {
		return this.workoutRepo.save(workout);
	}
	
	//get one Workout
	public Workout getOneWorkout(Long id) {
		return this.workoutRepo.findById(id).orElse(null);
	}
	
	//update one Workout
	public Workout updateWorkout(Workout workout) {
		return this.workoutRepo.save(workout);
	}
	
	
	//delete one Workout
	public void deleteWorkout(Long id) {
		this.workoutRepo.deleteById(id);
	}

}