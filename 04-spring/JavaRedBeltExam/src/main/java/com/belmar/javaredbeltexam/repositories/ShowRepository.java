package com.belmar.javaredbeltexam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.javaredbeltexam.models.Show;
@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {

}
