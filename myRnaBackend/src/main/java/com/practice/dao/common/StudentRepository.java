/**
 * 
 */
package com.practice.dao.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.common.Student;

/**
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 28/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public Student findById(int studentId);
	

}
