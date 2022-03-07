package com.belmar.mealclub.repositories;

import org.springframework.data.repository.CrudRepository;

import com.belmar.mealclub.models.Meal;



public interface MealRepository extends CrudRepository<Meal, Long>{

}