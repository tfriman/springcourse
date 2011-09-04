package com.houston.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceClientTest extends BaseWebContainerTest {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookServiceClient bookServiceClient;
	
	@Before
	public void before() {
		bookDao.reset();
		bookServiceClient.setBaseUrl(webContainer.getBaseUrl()+"rest");
	}
	
	@Test
	public void listBooksReturnsEmptyListIfNoBooksHasBeenSaved() {
		assertTrue(bookServiceClient.listBooks().isEmpty());
	}
	
	@Test
	public void createBook() {
		Book book = bookServiceClient.createBook(new Book("Aku-Ankka"));
		Book savedBook = bookDao.get(book.getId());
		
		assertEquals(book, savedBook);
	}
	
	@Test
	public void updateBook() {
		Book book = bookServiceClient.createBook(new Book("Aku-Ankka"));
		book.setTitle("Mikki-Hiiri");
		bookServiceClient.updateBook(book);
		
		Book updatedBook = bookDao.get(book.getId());
		assertEquals(book, updatedBook);
	}	
	
	@Test
	public void listBooks() {
		bookDao.create(new Book("Eka"));
		bookDao.create(new Book("Toka"));
		bookDao.create(new Book("Kolmas"));
		
		assertEquals(3, bookServiceClient.listBooks().size());
	}
}