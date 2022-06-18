package com.practice.dao.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.common.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

}
