package com.belmar.onemorerep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belmar.onemorerep.models.ExerciseInfo;
import com.belmar.onemorerep.repositories.ExerciseInfoRepository;

@Service
public class ExerciseInfoService {

	
	@Autowired private ExerciseInfoRepository exerciseInfoRepo;
	
	
	//create exerciseinfo
	public ExerciseInfo createExerciseInfo(ExerciseInfo exerciseInfo) {
		return this.exerciseInfoRepo.save(exerciseInfo);
	}
}
