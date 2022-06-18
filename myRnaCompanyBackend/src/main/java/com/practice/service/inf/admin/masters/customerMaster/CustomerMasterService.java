/**
 * 
 */
package com.practice.service.inf.admin.masters.customerMaster;

import java.util.List;

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

public interface CustomerMasterService {

	// this method used for to get all data By Status false.
	public List<CustomerMaster> findCustomerByStatus();

	// this method used for to get customer master data by id
	public CustomerMaster getCustomerMasterById(Long customerMasterId);

	// this method used for to get customer master max code
	public Long getMaxCustomerCode();

	// this method used for to get customer master data by customer code
	public CustomerMaster findByCustomerCode(Long customerCode);

	// this method used to save customer master data in db
	public CustomerMaster saveCustomerMaster(CustomerMaster customer);

	// this method used to save customer master signature in db
	public CustomerMaster saveCustomerMasterSignature(CustomerMaster customer, Long customerMasterId);

	// this method used to save customer master photo in db
	public CustomerMaster saveCustomerMasterPhoto(CustomerMaster customer, Long customerMasterId);

	// this method used for to update customer master data in db
	public void updateCustomerMaster(CustomerMaster customer, Long customerMasterId);

	// this method used for to delete customer data by id
	public void deleteCustomerMaster(Long customerMasterId);

	public CustomerMaster findByCustomerName(String customerName);

}
