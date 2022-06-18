/**
 * 
 */
package com.practice.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dao.common.AuthorRepository;
import com.practice.model.common.Author;

/**
 * @author sameer
 *
 */
@RestController
@CrossOrigin
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;

	@GetMapping("authors")
	public List<Author> getAuthors() {
		System.out.println("Ge All Authors");
		Author author = new Author();
		return this.authorRepository.findAll();
	}

	@PostMapping("/author")
	public Author saveAuthor(@RequestBody Author author) {
		System.out.println("Author Hit ==>> " + author);
		this.authorRepository.save(author);
		return author;
	}
}
