package com.houston.mvc;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertTableRowCountEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLink;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTextField;
import static net.sourceforge.jwebunit.junit.JWebUnit.submit;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * MAKE ALL TESTS PASS, DO NOT EDIT
 */
public class MovieControllerTest extends BaseWebContainerTest {

	@Autowired
	private MovieDao movieDao;
	
	@Before
    public void before() {
        movieDao.reset();
    }

    @Test
    public void titleOfListMoviesPage() {
        beginAt("app/movies");
        assertTitleEquals("List movies");
    }
    
    @Test
    public void movieListIsEmptyWhenDatabaseIsEmpty() {
    	beginAt("app/movies");
    	assertTableRowCountEquals("moviesTable", 0);
    }
    
    @Test
    public void createNewMovie() {
    	beginAt("app/movies");
    	clickLink("createMovieLink");
    	assertTitleEquals("Edit movie");
    
    	setTextField("name", "Zorro");
    	setTextField("duration", "123");
    	setTextField("date", "2011.07.24");
    	submit("Save");

    	assertTableRowCountEquals("moviesTable", 1);
    }
    
    @Test
    public void deleteMovie() {
    	movieDao.create(new Movie(1L, "Rambo II", 100, new DateTime()));
    	movieDao.create(new Movie(2L, "Lotr", 43, new DateTime()));
    	movieDao.create(new Movie(3L, "Bad Taste", 15, new DateTime()));
    	
    	beginAt("app/movies");
    	assertTableRowCountEquals("moviesTable", 3);
    	
    	clickLink("deleteMovieLink2");
    	assertTableRowCountEquals("moviesTable", 2);
    }
    
}
