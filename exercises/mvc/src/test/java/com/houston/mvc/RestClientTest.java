package com.houston.mvc;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * MAKE ALL TESTS PASS, DO NOT EDIT
 */
public class RestClientTest extends BaseWebContainerTest {

	@Autowired
	MovieDao movieDao;
	
	@Autowired 
	RestTemplate restTemplate;
	
	RestClient restClient;
	
	@Before
    public void before() {
        movieDao.reset();
        restClient = new RestClient();
        restClient.setBaseUrl(jettyServer.getBaseUrl());
        restClient.setRestTemplate(restTemplate);
    }
	
	@Test
	public void getMovie() {
		Movie movie = movieDao.create(new Movie("my movie", 23, new DateTime()));
		Movie retrievedMovie = restClient.getMovie(1L);
		
		assertEquals(movie.getName(), retrievedMovie.getName());
	}
	
	@Test
	public void listMovies() {
		movieDao.create(new Movie("A", 1, new DateTime()));
		movieDao.create(new Movie("B", 3, new DateTime()));
		movieDao.create(new Movie("C", 5, new DateTime()));
		
		assertEquals(3, restClient.listMovies().size());
	}
}