package com.houston.mvc;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 * FOLLOW INSTRUCTIONS IN EACH METHOD, EVERYTHING CAN BE DONE USING ONLY ANNOTATIONS
 */
public class MovieController {

	// TODO: Inject dependency
	private MovieDao movieDao;
	
	// TODO: Map to url: "/movies" with GET
	public String list(Model model) {
		model.addAttribute("movies", movieDao.list());
		return "list";
	}
	
	// TODO: Map to url: "/movie/{movieId}" with GET
	// Read movieId from path variable "movieId"
	public String edit(Long movieId, Model model) {
		model.addAttribute("movie", movieDao.get(movieId));
		return "edit";
	}
	
	// TODO: Map to url: "/movie/{movieId}" with POST
	// Use annotation to validate movie parameter
	// Use annotation to read/store movie to model with name "movie"	
	public String updateMovie(Movie movie, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		} else {
			movieDao.update(movie);
			return "redirect:/app/movies";
		}
	}	

	// TODO: Map to url: "/movie/create" with GET
	public String create(Model model) {
		model.addAttribute("movie", new Movie());
		return "edit";
	}	
	
	// TODO: Map to url: "/movie/create" with POST 
	// Use annotation to validate movie parameter
	// Use annotation to read/store movie to model with name "movie"
	public String createMovie(Movie movie, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		} else {
			movieDao.create(movie);
			return "redirect:/app/movies";
		}
	}
	
	// TODO: Map to url: "/movie/delete" with POST
	// Read movieId from request parameter named "movieId"
	public String deleteMovie(Long movieId) {
		movieDao.delete(movieId);
		return "redirect:/app/movies";
	}
	
	// TODO: Map to url: "/movie/show/{movieId}" with GET
	// Write movie to response, so it will be serialized to JSON
	// Read movieId from path variable "movieId"
	public Movie show(Long movieId) {
		return movieDao.get(movieId);
	}
	
	// TODO: Map to url: "/movies/list" with GET
	// Write movies to response, so they will be serialized to JSON
	public List<Movie> list() {
		return movieDao.list();
	}
}