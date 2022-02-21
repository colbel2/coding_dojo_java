package com.belmar.loginregistration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.loginregistration.models.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
