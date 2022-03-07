package com.belmar.bookclub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belmar.bookclub.models.Book;
import com.belmar.bookclub.repositories.BookRepository;




@Service
public class BookService {

	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	
	//methods the book service can perform
	public List<Book> findAllBooks(){
		return (List<Book>)this.bookRepo.findAll();
	}
	
	//create a new meal
	public Book createBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	
	public Book getBook(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}
	
	
}