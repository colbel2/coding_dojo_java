package com.belmar.javaredbeltexam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belmar.javaredbeltexam.models.Book;
import com.belmar.javaredbeltexam.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	//methods for book club 
	
	public List<Book> findAllBooks(){
		return (List<Book>)this.bookRepo.findAll();
	}

	//create new book
	public Book createBook(Book book) {
		return this.bookRepo.save(book);
	}

	//get book
	public Book getBook(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}

}

