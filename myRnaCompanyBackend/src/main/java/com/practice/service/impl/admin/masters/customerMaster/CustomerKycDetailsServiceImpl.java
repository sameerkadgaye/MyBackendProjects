/**
 * 
 */
package com.practice.service.impl.admin.masters.customerMaster;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.customerMaster.CustomerKycDetailsRepository;
import com.practice.model.admin.masters.customerMaster.CustomerKycDetails;
import com.practice.service.inf.admin.masters.customerMaster.CustomerKycDetailsService;

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

@Service
public class CustomerKycDetailsServiceImpl implements CustomerKycDetailsService {

	@Autowired
	private CustomerKycDetailsRepository customerKycDetailsRepository;

	/**
	 * 
	 */
	public CustomerKycDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CustomerKycDetails> findCustomerKycDetailsByStatus() {
		return this.customerKycDetailsRepository.findCustomerKycDetailsByStatus();
	}

	@Override
	public CustomerKycDetails findByCustomerKycDetailsId(Long customerKycDetailsId) {
		return this.customerKycDetailsRepository.findById(customerKycDetailsId).get();
	}

	@Override
	public CustomerKycDetails saveCustomerKycDetails(CustomerKycDetails customerKycDetails) {
		return this.customerKycDetailsRepository.save(customerKycDetails);
	}

	@Override
	public List<CustomerKycDetails> saveCustomerKycDetailsList(List<CustomerKycDetails> customerKycDetails) {
		return this.customerKycDetailsRepository.saveAll(customerKycDetails);
	}

//	@Override
//	public CustomerKycDetails saveCustomerKycFile(CustomerKycDetails customerKycDetails) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void saveCustomerKycFile(CustomerKycDetails customerKycFile, Long customerKycDetailsId) throws IOException {
		customerKycFile.setCustomerKycDetailsId(customerKycDetailsId);
		this.customerKycDetailsRepository.save(customerKycFile);
	}

	@Override
	public void updateCustomerKycDetails(CustomerKycDetails customerKycDetails, Long customerKycDetailsId) {
		customerKycDetails.setCustomerKycDetailsId(customerKycDetailsId);
		this.customerKycDetailsRepository.save(customerKycDetails);
	}

	@Override
	public void updateCustomerKycDocuments(CustomerKycDetails customerKycFile, Long customerKycDetailsId)
			throws IOException {
		customerKycFile.setCustomerKycDetailsId(customerKycDetailsId);
		this.customerKycDetailsRepository.save(customerKycFile);

	}

	@Override
	public void deleteCustomerKycDetails(Long customerKycDetailsId) {
		this.customerKycDetailsRepository.deleteById(customerKycDetailsId);
	}

}
