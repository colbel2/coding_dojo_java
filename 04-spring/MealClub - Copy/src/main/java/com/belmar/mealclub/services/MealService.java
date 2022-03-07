package com.belmar.mealclub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belmar.mealclub.models.Meal;
import com.belmar.mealclub.repositories.MealRepository;



@Service
public class MealService {

	private final MealRepository mealRepo;
	
	public MealService(MealRepository mealRepo) {
		this.mealRepo = mealRepo;
	}
	
	
	//methods the mealservice can perform
	public List<Meal> findAllMeals(){
		return (List<Meal>)this.mealRepo.findAll();
	}
	
	//create a new meal
	public Meal createMeal(Meal meal) {
		return this.mealRepo.save(meal);
	}
	
	
	public Meal getMeal(Long id) {
		return this.mealRepo.findById(id).orElse(null);
	}
	
	public Meal updateMeal(Meal meal) {
		return this.mealRepo.save(meal);
	}
	
	
	public void deleteMeal(Long id) {
		this.mealRepo.deleteById(id);
	}
	
}