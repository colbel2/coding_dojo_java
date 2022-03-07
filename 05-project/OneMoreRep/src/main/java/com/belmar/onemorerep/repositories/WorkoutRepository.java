package com.belmar.onemorerep.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.onemorerep.models.Workout;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long>{

}
