package com.houston.mvc;

/**
 * DO NOT EDIT
 */
public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final Long id;

	public MovieNotFoundException(Long id) {
		super("Movie not found with id: " + id);
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
