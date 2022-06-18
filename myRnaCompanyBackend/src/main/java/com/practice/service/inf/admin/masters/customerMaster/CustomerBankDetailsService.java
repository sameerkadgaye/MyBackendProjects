/**
 * 
 */
package com.practice.service.inf.admin.masters.customerMaster;

import java.util.List;

import com.practice.model.admin.masters.customerMaster.CustomerBankDetails;

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

public interface CustomerBankDetailsService {

	// this method used for to get all data By Bank Status false.
	public List<CustomerBankDetails> findCustomerBankDetailsByBankStatus();

	// this method used for to get customer bank details data by id
	public CustomerBankDetails findByCustomerBankDetailsId(Long customerBankDetailsId);

	// this method used for to save customer bank details data
	public CustomerBankDetails saveCustomerBankDetails(CustomerBankDetails customerBankDetails);

	// this method used for to save customer bank details list data
	public List<CustomerBankDetails> saveCustomerBankDetailsList(List<CustomerBankDetails> customerBankDetailsList);

	// this method used for to update customer bank details data
	public void updateCustomerBankDetails(CustomerBankDetails customerBankDetails, Long customerBankDetailsId);

	// this method used for to delete customer bank details data
	public void deleteCustomerBankDetails(Long customerBankDetailsId);

	// find CustomerBankDetails List Customer Id Wise
	public List<CustomerBankDetails> getCustomerBankDetailsByCustomerMasterId(Long customerMasterId);

}
