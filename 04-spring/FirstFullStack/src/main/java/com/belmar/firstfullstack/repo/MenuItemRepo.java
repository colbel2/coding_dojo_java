package com.belmar.firstfullstack.repo;

import org.springframework.data.repository.CrudRepository;

import com.belmar.firstfullstack.models.MenuItem;

public interface MenuItemRepo extends CrudRepository<MenuItem, Long> {

}
