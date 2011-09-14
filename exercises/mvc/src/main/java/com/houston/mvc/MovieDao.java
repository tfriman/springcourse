package com.houston.mvc;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

/**
 * DO NOT EDIT
 */
@Repository
public class MovieDao {

	private static final AtomicLong idSequence = new AtomicLong();
	private static final Map<Long, Movie> movies = new Hashtable<Long, Movie>();
	
	public Movie create(Movie Movie) {
		if (Movie == null) {
			throw new IllegalArgumentException("Movie can't be null");
		}
		
		Movie newMovie = Movie.clone();
		newMovie.setId(idSequence.incrementAndGet());
		movies.put(newMovie.getId(), newMovie);
		return newMovie;
	}
	
	public Movie update(Movie Movie) {
		if (Movie == null) {
			throw new IllegalArgumentException("Movie can't be null");
		}
		
		movies.put(Movie.getId(), Movie.clone());
		return Movie;
	}
	
	public Movie get(Long id) {
		Movie movie = movies.get(id);
		if (movie == null) {
			throw new MovieNotFoundException(id);
		}
		
		return movie.clone();
	}

	public List<Movie> list() {
		List<Movie> list = new ArrayList<Movie>();
		for (Movie Movie : new ArrayList<Movie>(movies.values())) {
			list.add(Movie.clone());
		}
		
		return list;
	}
	
	public void reset() {
		movies.clear();
	}

	public void delete(Long id) {
		movies.remove(id);
	}
}