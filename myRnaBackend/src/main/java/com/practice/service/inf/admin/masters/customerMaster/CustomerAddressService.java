/**
 * 
 */
package com.practice.service.inf.admin.masters.customerMaster;

import java.util.List;

import com.practice.model.admin.masters.customerMaster.CustomerAddress;

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

public interface CustomerAddressService {

	// this method used for to get all data By Status false.
	public List<CustomerAddress> findCustomerAddressByStatus();

	// this method used for to get customer address data by id
	public CustomerAddress findByCustomerAddressId(Long customerAddressId);

	// this method used for to save customer address data
	public CustomerAddress saveCustomerAddress(CustomerAddress customerAddress);

	// this method used for to save customer address list data
	public List<CustomerAddress> saveCustomerAddressList(List<CustomerAddress> customerAddressList);

	// this method used for to update customer address data
	public void updateCustomerAddress(CustomerAddress customerAddress, Long customerAddressId);

	// this method used for to delete customer address data
	public void deleteCustomerAddress(Long customerAddressId);

	// find CustomerAddress List Customer Id Wise
	public List<CustomerAddress> getCustomerAddressByCustomerMasterId(Long customerMasterId);

}
