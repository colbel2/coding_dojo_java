package com.belmar.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;

import com.belmar.bookclub.models.Book;





public interface BookRepository extends CrudRepository<Book, Long>{

}