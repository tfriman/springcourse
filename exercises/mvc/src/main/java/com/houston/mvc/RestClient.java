package com.houston.mvc;

import java.util.List;

import org.springframework.web.client.RestTemplate;

/**
 * Implement methods with TODO.
 * Register this bean using xml in movie-servlet.xml.
 */
public class RestClient {

	private RestTemplate restTemplate;
	
	private String baseUrl;
	
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public void setRestTemplate(RestTemplate template) {
		this.restTemplate = template;
	}
	
	protected String computeUrl(String relativePath) {
		if (baseUrl == null) {
			throw new IllegalStateException();
		}
		return baseUrl + relativePath;
	}
	
	public Movie getMovie(Long movieId) {
		// TODO: IMPLEMENT THIS WITH REST TEMPLATE
		return null;
	}

	public List<Movie> listMovies() {
		// TODO: IMPLEMENT THIS WITH REST TEMPLATE
		return null;
	}
}
