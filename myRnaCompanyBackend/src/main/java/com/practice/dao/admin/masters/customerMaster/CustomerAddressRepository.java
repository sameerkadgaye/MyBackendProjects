/**
 * 
 */
package com.practice.dao.admin.masters.customerMaster;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.masters.customerMaster.CustomerAddress;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 01/12/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {

	@Query("from CustomerAddress as p where p.status = false") // HQL Script
	public List<CustomerAddress> findCustomerAddressByStatus();

	public CustomerAddress findByCustomerAddressId(Long customerAddressId);

	public List<CustomerAddress> findByCustomerMaster(CustomerMaster customerMaster);

//	public CustomerAddress saveCustomerAddress(CustomerAddress customerAddress);

}
