/**
 * 
 */
package com.practice.dao.admin.masters.customerMaster;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.customerMaster.CustomerBankDetails;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 23/12/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Repository
public interface CustomerBankDetailsRepository extends JpaRepository<CustomerBankDetails, Long> {

	@Query("from CustomerBankDetails as p where p.bankStatus = false") // HQL Script
	public List<CustomerBankDetails> findCustomerBankDetailsByBankStatus();

	public CustomerBankDetails findByCustomerBankDetailsId(Long customerBankDetailsId);

	public List<CustomerBankDetails> findByCustomerMaster(CustomerMaster customerMaster);

}
