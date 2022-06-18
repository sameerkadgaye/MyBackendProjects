/**
 * 
 */
package com.practice.dao.admin.masters.customerMaster;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.customerMaster.CustomerKycDetails;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 04/12/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Repository
public interface CustomerKycDetailsRepository extends JpaRepository<CustomerKycDetails, Long> {

	@Query("from CustomerKycDetails as p where p.status = false") // HQL Script
	public List<CustomerKycDetails> findCustomerKycDetailsByStatus();

	public CustomerKycDetails findCustomerKycDetailsByDocumentFileName(String documentFileName);

}
