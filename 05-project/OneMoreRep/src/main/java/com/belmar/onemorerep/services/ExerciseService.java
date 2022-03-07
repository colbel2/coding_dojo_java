package com.belmar.onemorerep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belmar.onemorerep.models.Exercise;
import com.belmar.onemorerep.repositories.ExerciseRepository;

@Service
public class ExerciseService {

	@Autowired private ExerciseRepository exerciseRepo;
	
	//create exercise
	public Exercise createExercise(Exercise exercise) {
		return this.exerciseRepo.save(exercise);
	}
	
	
	//find one exercise
	public Exercise getOneExercise( Long id) {
		return this.exerciseRepo.findById(id).orElse(null);
	}
	
}
