/**
 * 
 */
package com.practice.dao.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.common.Author;

/**
 * @author sameer
 *
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
