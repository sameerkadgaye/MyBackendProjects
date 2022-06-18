/**
 * 
 */
package com.practice.service.impl.admin.masters.customerMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.customerMaster.CustomerMasterRepository;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;
import com.practice.service.inf.admin.masters.customerMaster.CustomerMasterService;

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

@Service
public class CustomerMasterServiceImpl implements CustomerMasterService {

	@Autowired
	private CustomerMasterRepository customerMasterRepository;

	/**
	 * 
	 */
	public CustomerMasterServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<CustomerMaster> findCustomerByStatus() {
		return this.customerMasterRepository.findCustomerByStatus();
	}

	@Override
	public CustomerMaster getCustomerMasterById(Long customerMasterId) {
		CustomerMaster customer = null;
		try {
			customer = this.customerMasterRepository.findByCustomerMasterId(customerMasterId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Long getMaxCustomerCode() {
		return this.customerMasterRepository.getMaxCustomerCode();
	}

	@Override
	public CustomerMaster findByCustomerCode(Long customerCode) {
		return this.customerMasterRepository.findByCustomerCode(customerCode);
	}

	@Override
	public CustomerMaster saveCustomerMaster(CustomerMaster customer) {
		CustomerMaster saveCustomer = this.customerMasterRepository.save(customer);
		return saveCustomer;
	}

	@Override
	public CustomerMaster saveCustomerMasterSignature(CustomerMaster customer, Long customerMasterId) {
		customer.setCustomerMasterId(customerMasterId);
		CustomerMaster saveCustomerSignature = this.customerMasterRepository.save(customer);
		return saveCustomerSignature;
	}

	@Override
	public CustomerMaster saveCustomerMasterPhoto(CustomerMaster customer, Long customerMasterId) {
		customer.setCustomerMasterId(customerMasterId);
		CustomerMaster saveCustomerPhoto = this.customerMasterRepository.save(customer);
		return saveCustomerPhoto;
	}

	@Override
	public void updateCustomerMaster(CustomerMaster customer, Long customerMasterId) {
		customer.setCustomerMasterId(customerMasterId);
		this.customerMasterRepository.save(customer);
	}

	@Override
	public void deleteCustomerMaster(Long customerMasterId) {
		this.customerMasterRepository.deleteById(customerMasterId);
	}

	@Override
	public CustomerMaster findByCustomerName(String customerName) {
		// TODO Auto-generated method stub
		return customerMasterRepository.findByFullName(customerName);
	}

}
