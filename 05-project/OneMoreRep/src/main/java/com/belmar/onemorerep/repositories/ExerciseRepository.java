package com.belmar.onemorerep.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.onemorerep.models.Exercise;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

}
