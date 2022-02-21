package com.belmar.teamsplayers.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.teamsplayers.models.Team;

@Repository
public interface TeamRepo extends CrudRepository<Team, Long> {//name of model goes where team is

}
