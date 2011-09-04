package com.houston.rest;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	private static final AtomicLong idSequence = new AtomicLong();
	private static final Map<Long, Book> books = new Hashtable<Long, Book>();
	
	public Book create(Book book) {
		if (book == null) {
			throw new IllegalArgumentException("Book to create can't be null");
		}
		
		Book newBook = book.clone();
		newBook.setId(idSequence.incrementAndGet());
		books.put(newBook.getId(), newBook);
		return newBook;
	}
	
	public Book update(Book book) {
		if (book == null) {
			throw new IllegalArgumentException("Book to update can't be null");
		}
		
		books.put(book.getId(), book.clone());
		return book;
	}
	
	public Book get(Long id) {
		Book book = books.get(id);
		if (book == null) {
			throw new BookNotFoundException(id);
		}
		
		return book.clone();
	}

	public List<Book> list() {
		List<Book> list = new ArrayList<Book>();
		for (Book book : new ArrayList<Book>(books.values())) {
			list.add(book.clone());
		}
		
		return list;
	}
	
	public void reset() {
		books.clear();
	}
}