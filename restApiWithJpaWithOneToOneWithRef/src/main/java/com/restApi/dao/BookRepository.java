/**
 * 
 */
package com.restApi.dao;

import org.springframework.data.repository.CrudRepository;

import com.restApi.model.Book;

/**
 * @author sameer
 *
 */
public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
