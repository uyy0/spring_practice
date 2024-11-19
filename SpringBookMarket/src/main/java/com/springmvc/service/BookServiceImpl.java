package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl의 getAllBookList실행됨");
		return bookRepository.getAllBookList();
	}
	
	public List<Book> getBookListByCategory(String category){
		System.out.println("BookServiceImpl의 getBookListByCategory 실행됨");
		List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
		return booksByCategory;
	}
	
	public Set<Book> getBookListByFilter(Map<String, List<String>>filter){
		System.out.println("BookServiceImpl의 getBookListByFilter 실행됨");
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		return booksByFilter;
	}
	
	public Book getBookById(String bookId) {
		System.out.println("BookServiceImpl의 getBookById 실행됨");
		Book bookById = bookRepository.getBookById(bookId);
		return bookById;
	}
	public void setNewBook(Book book) {
		bookRepository.setNewBook(book);
	}
}
