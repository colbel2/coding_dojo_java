package com.belmar.firstfullstack.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.firstfullstack.models.MenuItem;

@Repository
public interface MenuItemRepo extends CrudRepository<MenuItem, Long> {

}
