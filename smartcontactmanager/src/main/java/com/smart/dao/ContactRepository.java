/**
 * 
 */
package com.smart.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.model.Contact;

/**
 * @author sameer
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Integer> {
//Pagination Logic

	// current-page
	// contact-per-page-5
	@Query("from Contact as c where c.user.userId =:userId")
	public Page<Contact> findContactsByUser(@Param("userId") Integer userId, Pageable perPageable);

}
