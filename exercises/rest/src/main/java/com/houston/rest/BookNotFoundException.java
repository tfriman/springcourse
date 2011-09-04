package com.houston.rest;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final Long id;

	public BookNotFoundException(Long id) {
		super("Book not found with id: " + id);
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
