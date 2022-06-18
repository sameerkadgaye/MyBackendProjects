/**
 * 
 */
package com.practice.service.impl.admin.masters.customerMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.customerMaster.CustomerAddressRepository;
import com.practice.dao.admin.masters.customerMaster.CustomerMasterRepository;
import com.practice.model.admin.masters.customerMaster.CustomerAddress;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;
import com.practice.service.inf.admin.masters.customerMaster.CustomerAddressService;

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

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {

	@Autowired
	private CustomerAddressRepository customerAddressRepository;

	@Autowired
	private CustomerMasterRepository customerMasterRepository;

	public List<CustomerAddress> findCustomerAddressByStatus() {
		return this.customerAddressRepository.findCustomerAddressByStatus();
	}

	@Override
	public CustomerAddress findByCustomerAddressId(Long customerAddressId) {
		return this.customerAddressRepository.findById(customerAddressId).get();
//		return this.customerAddressRepository.findByCustomerAddressId(customerAddressId);
	}

	@Override
	public CustomerAddress saveCustomerAddress(CustomerAddress customerAddress) {
		return this.customerAddressRepository.save(customerAddress);
	}

	@Override
	public List<CustomerAddress> saveCustomerAddressList(List<CustomerAddress> customerAddressList) {
		return this.customerAddressRepository.saveAll(customerAddressList);
	}

	@Override
	public void updateCustomerAddress(CustomerAddress customerAddress, Long customerAddressId) {
		customerAddress.setCustomerAddressId(customerAddressId);
		this.customerAddressRepository.save(customerAddress);
	}

	@Override
	public void deleteCustomerAddress(Long customerAddressId) {
		this.customerAddressRepository.deleteById(customerAddressId);
	}

	@Override
	public List<CustomerAddress> getCustomerAddressByCustomerMasterId(Long customerMasterId) {
		CustomerMaster customerMaster = this.customerMasterRepository.findById(customerMasterId).get();
		return this.customerAddressRepository.findByCustomerMaster(customerMaster);
	}

//	@Override
//	public CustomerAddress findByCustomerAddressId(Long customerAddressId) {
//		CustomerAddress customer = null;
//		try {
//			customer = this.customerAddressRepository.findByCustomerAddressId(customerAddressId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return customer;
//	}

}
