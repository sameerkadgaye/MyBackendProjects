/**
 * 
 */
package com.practise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.model.Company;

/**
 * @author HP
 *
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
	
	//public Employee findByEmployeeId(Long employeeId);

}
