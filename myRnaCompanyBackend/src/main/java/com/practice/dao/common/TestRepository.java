/**
 * 
 */
package com.practice.dao.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.common.Test;

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
public interface TestRepository extends JpaRepository<Test, Long>{

//	 @Query("SELECT max(glCode) FROM GlMaster where glType= ?1") 
	 @Query("SELECT max(testApplicationNo)+1 FROM Test") 
	 public Long getMaxTestApplicationNo();
}
