package com.belmar.mealclub.repositories;

import org.springframework.data.repository.CrudRepository;

import com.belmar.mealclub.models.Book;



public interface BookRepository extends CrudRepository<Book, Long>{

}