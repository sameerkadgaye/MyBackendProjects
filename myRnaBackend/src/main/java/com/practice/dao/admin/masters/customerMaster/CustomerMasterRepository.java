/**
 * 
 */
package com.practice.dao.admin.masters.customerMaster;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.customerMaster.CustomerMaster;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 16/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Repository
public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long> {

	public CustomerMaster findByCustomerMasterId(Long customerMasterId);

	@Query("from CustomerMaster as p where p.status = false order by customerCode DESC") // HQL Script
	public List<CustomerMaster> findCustomerByStatus();

	@Query("SELECT max(customerCode)+1 FROM CustomerMaster")
	public Long getMaxCustomerCode();

	public CustomerMaster findByCustomerCode(Long customerCode);

	public CustomerMaster findByFullName(String customerName);

}
