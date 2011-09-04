package com.houston.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceClient {

	public static class BookResult {
		
		private Book book;
		
		public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}
	}
	
	public static class BookListResult {
		
		private List<Book> bookList;

		public List<Book> getBookList() {
			return bookList;
		}

		public void setBookList(List<Book> bookList) {
			this.bookList = bookList;
		}
	}
	
	@Autowired
	protected RestTemplate template;
	
	private String baseUrl;

	protected String computeUrl(String relativePath) {
		if (baseUrl == null) {
			throw new IllegalStateException();
		}
		return baseUrl + "/" + relativePath;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Book getBook(Long bookId) {
		Map<String, String> variables = new HashMap<String, String>();
		variables.put("bookId", bookId.toString());
		BookResult result = template.getForObject(computeUrl("book/{bookId}"), BookResult.class, variables);
		return result.getBook();
	}
	
	public Book createBook(Book book) {
		BookResult result = template.postForObject(computeUrl("book/create"), book, BookResult.class);
		return result.getBook();
	}
	
	public Book updateBook(Book book) {
		Map<String, String> variables = new HashMap<String, String>();
		variables.put("bookId", book.getId().toString());		
		BookResult result = template.postForObject(computeUrl("book/{bookId}"), book, BookResult.class, variables);
		return result.getBook();
	}
	
	public List<Book> listBooks() {
		BookListResult result = template.getForObject(computeUrl("books"), BookListResult.class);
		return result.getBookList();
	}
}