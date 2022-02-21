package com.belmar.mealclub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belmar.mealclub.models.Book;
import com.belmar.mealclub.repositories.BookRepository;



@Service
public class BookService {

	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	
	//methods the bookservice can perform
	public List<Book> findAllBooks(){
		return (List<Book>)this.bookRepo.findAll();
	}
	
	//create a new book
	public Book createBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	
	public Book getBook(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}
	
	public Book updateBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	
	public void deleteBook(Long id) {
		this.bookRepo.deleteById(id);
	}
	
}