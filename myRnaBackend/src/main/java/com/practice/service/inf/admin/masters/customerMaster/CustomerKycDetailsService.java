/**
 * 
 */
package com.practice.service.inf.admin.masters.customerMaster;

import java.io.IOException;
import java.util.List;

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
public interface CustomerKycDetailsService {

	// this method used for to get all data By Status false.
	public List<CustomerKycDetails> findCustomerKycDetailsByStatus();

	// this method used for to get customer kyc details data by id
	public CustomerKycDetails findByCustomerKycDetailsId(Long customerKycDetailsId);

	// this method used for to save customer kyc details data
	public CustomerKycDetails saveCustomerKycDetails(CustomerKycDetails customerKycDetails);

	// this method used for to save customer kyc details list data
	public List<CustomerKycDetails> saveCustomerKycDetailsList(List<CustomerKycDetails> customerKycDetails);

	// this method used for to save customer kyc file data
//	public CustomerKycDetails saveCustomerKycFile(CustomerKycDetails customerKycDetails);

	// this method used for to save customer kyc file data
	public void saveCustomerKycFile(CustomerKycDetails customerKycFile, Long customerKycDetailsId) throws IOException;

	// this method used for to update customer kyc details data
	public void updateCustomerKycDetails(CustomerKycDetails customerKycDetails, Long customerKycDetailsId);

	// this method used for to update customer kyc details data
	public void updateCustomerKycDocuments(CustomerKycDetails customerKycFile, Long customerKycDetailsId)
			throws IOException;

	// this method used for to delete customer kyc details data
	public void deleteCustomerKycDetails(Long customerKycDetailsId);

}
