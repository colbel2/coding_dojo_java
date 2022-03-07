package com.belmar.onemorerep.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.onemorerep.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	
	
	Optional<User> findByEmail(String email);
	

}