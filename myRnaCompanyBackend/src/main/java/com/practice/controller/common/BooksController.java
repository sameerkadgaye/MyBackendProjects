/**
 * 
 */
package com.practice.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dao.common.BooksRepository;
import com.practice.model.common.Books;

/**
 * @author sameer
 *
 */
@RestController
@CrossOrigin
public class BooksController {

	@Autowired
	private BooksRepository booksRepository;
	
	@GetMapping("books")
	public List<Books> getAuthors() {
		System.out.println("Ge All Books");
		return this.booksRepository.findAll();
	}
}
