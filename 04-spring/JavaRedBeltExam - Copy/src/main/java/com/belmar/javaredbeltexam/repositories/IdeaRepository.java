package com.belmar.javaredbeltexam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.javaredbeltexam.models.Idea;
@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {

}
