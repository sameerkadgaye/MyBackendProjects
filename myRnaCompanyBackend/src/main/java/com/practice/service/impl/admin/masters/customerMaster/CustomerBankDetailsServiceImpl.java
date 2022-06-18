/**
 * 
 */
package com.practice.service.impl.admin.masters.customerMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.customerMaster.CustomerBankDetailsRepository;
import com.practice.dao.admin.masters.customerMaster.CustomerMasterRepository;
import com.practice.model.admin.masters.customerMaster.CustomerBankDetails;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;
import com.practice.service.inf.admin.masters.customerMaster.CustomerBankDetailsService;

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

@Service
public class CustomerBankDetailsServiceImpl implements CustomerBankDetailsService {

	@Autowired
	private CustomerBankDetailsRepository customerBankDetailsRepository;

	@Autowired
	private CustomerMasterRepository customerMasterRepository;

	@Override
	public List<CustomerBankDetails> findCustomerBankDetailsByBankStatus() {
		return this.customerBankDetailsRepository.findCustomerBankDetailsByBankStatus();
	}

	@Override
	public CustomerBankDetails findByCustomerBankDetailsId(Long customerBankDetailsId) {
		return this.customerBankDetailsRepository.findById(customerBankDetailsId).get();
	}

	@Override
	public CustomerBankDetails saveCustomerBankDetails(CustomerBankDetails customerBankDetails) {
		return this.customerBankDetailsRepository.save(customerBankDetails);
	}

	@Override
	public List<CustomerBankDetails> saveCustomerBankDetailsList(List<CustomerBankDetails> customerBankDetailsList) {
		return this.customerBankDetailsRepository.saveAll(customerBankDetailsList);
	}

	@Override
	public void updateCustomerBankDetails(CustomerBankDetails customerBankDetails, Long customerBankDetailsId) {
		customerBankDetails.setCustomerBankDetailsId(customerBankDetailsId);
		this.customerBankDetailsRepository.save(customerBankDetails);
	}

	@Override
	public void deleteCustomerBankDetails(Long customerBankDetailsId) {
		this.customerBankDetailsRepository.deleteById(customerBankDetailsId);
	}

	@Override
	public List<CustomerBankDetails> getCustomerBankDetailsByCustomerMasterId(Long customerMasterId) {
		CustomerMaster customerMaster = this.customerMasterRepository.findById(customerMasterId).get();
		return this.customerBankDetailsRepository.findByCustomerMaster(customerMaster);
	}

}
