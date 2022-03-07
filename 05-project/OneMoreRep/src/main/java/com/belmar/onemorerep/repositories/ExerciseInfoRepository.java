package com.belmar.onemorerep.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.onemorerep.models.ExerciseInfo;

@Repository
public interface ExerciseInfoRepository extends CrudRepository<ExerciseInfo, Long> {

}
