package com.houston.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookServiceController {

	@Autowired
	private BookDao bookDao;
	
	@RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
	public Book getBook(@PathVariable("bookId") Long bookId) {
		return bookDao.get(bookId);
	}
	
	@RequestMapping(value = "/book/create", method = RequestMethod.POST)
	public Book createBook(@RequestBody Book book) {
		return bookDao.create(book);
	}
	
	@RequestMapping(value = "/book/{bookId}", method = RequestMethod.POST)
	public Book updateBook(@RequestBody Book book) {
		return bookDao.update(book);
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> listBooks() {
		return bookDao.list();
	}
}