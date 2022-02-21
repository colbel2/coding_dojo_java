package com.belmar.teamsplayers.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.teamsplayers.models.Player;


@Repository
public interface Playerrepo extends CrudRepository<Player, Long> {

}
