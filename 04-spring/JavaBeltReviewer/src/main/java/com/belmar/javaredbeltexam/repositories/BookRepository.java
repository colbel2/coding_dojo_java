package com.belmar.javaredbeltexam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.javaredbeltexam.models.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
