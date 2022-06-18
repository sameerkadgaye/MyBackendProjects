/**
 * 
 */
package com.restApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restApi.dao.BookRepository;
import com.restApi.model.Book;

/**
 * @author sameer
 *
 */
@Component
//Or
//@Service
public class BookService {

	/**
	 * 
	 */
	public BookService() {
	}

	@Autowired
	private BookRepository bookRepository;

	// Rest API'S :- Read Data Start.
	// get All LIst
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;

	}

	// get single Book by id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findById(id);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return book;
	}
	// Rest API'S :- Read Data End.

	// Rest API'S :- Save or create Data Start
	public Book addBook(Book b) {
		Book book = bookRepository.save(b);
		return book;
	}
	// Rest API'S :- Save or create Data End

	// Rest API'S :- Delete Data Start
	public void deleteBook(int bookId) {
		this.bookRepository.deleteById(bookId);
	}
	// Rest API'S :- Delete Data End

	// Rest API'S :- Update Data Start
	public void updateBook(Book book, int bookid) {
		book.setId(bookid);
		this.bookRepository.save(book);
	}
	// Rest API'S :- Update Data End

}
