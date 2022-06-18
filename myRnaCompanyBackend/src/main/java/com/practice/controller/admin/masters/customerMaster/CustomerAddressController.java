/**
 * 
 */
package com.practice.controller.admin.masters.customerMaster;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.masters.customerMaster.CustomerAddress;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.customerMaster.CustomerAddressService;

/**
 * @author SUMIT KANASKAR
 * @version 0.2
 * 
 *          Created Date : 28/10/2021
 * 
 *          Updated Date : 09/12/2021
 * 
 *          Updated By : SAMEER KADGAYE
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/master")
public class CustomerAddressController {

	@Autowired
	private CustomerAddressService customerAddressService;

	@GetMapping("/customerAddresses")
	public ResponseEntity<RequestResponse> getCustomerAddress() {
		List<CustomerAddress> customerAddressList = customerAddressService.findCustomerAddressByStatus();

		if (customerAddressList.size() <= 0)
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.OK,
					null);
		else
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, customerAddressList);
	}

	@GetMapping("/customerAddress/{customerAddressId}")
	public ResponseEntity<RequestResponse> getCustomerAddressById(
			@PathVariable("customerAddressId") Long customerAddressId) {
		CustomerAddress customerAddress = customerAddressService.findByCustomerAddressId(customerAddressId);

		if (customerAddress == null)
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					null);
		else
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, customerAddress);
	}

	@PostMapping("/customerAddress/{customerId}")
	public ResponseEntity<RequestResponse> saveCustomerAddress(@PathVariable("customerId") CustomerMaster customerId,
			@RequestBody CustomerAddress customerAddress) {
		System.out.println("Customer Address Save Hitted : " + customerAddress);

		try {
			customerAddress.setStatus(false);
			customerAddress.setCustomerMaster(customerId);

			CustomerAddress savedAddress = this.customerAddressService.saveCustomerAddress(customerAddress);
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
					savedAddress);
		} catch (Exception e) {
			System.out.println("Inside Catch : SaveAddress");
			e.printStackTrace();
			// TODO: handle exception

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveFailed,
					HttpStatus.NOT_MODIFIED, e);
		}
	}

	@PostMapping("/customerAddresses")
	public ResponseEntity<RequestResponse> saveListCustomerAddress(@RequestBody List<CustomerAddress> customerAddress) {
		System.out.println("Customer Address List Save Hitted : " + customerAddress);

		try {
			this.customerAddressService.saveCustomerAddressList(customerAddress);
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
					customerAddress);
		} catch (Exception e) {
			System.out.println("Inside Catch : SaveAddressList");
			e.printStackTrace();
			// TODO: handle exception

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveFailed,
					HttpStatus.NOT_MODIFIED, e);
		}
	}

	@PutMapping("/customerAddress/{customerAddressId}")
	public ResponseEntity<RequestResponse> updateCustomerAddress(
			@PathVariable("customerAddressId") Long customerAddressId) {
		System.out.println("Customer Address Update Hitted : Id : " + customerAddressId);

		try {
			CustomerAddress customerAddress = this.customerAddressService.findByCustomerAddressId(customerAddressId);

			customerAddress.setStatus(true);
			customerAddress.setCustomerMaster(null);
			this.customerAddressService.updateCustomerAddress(customerAddress, customerAddressId);
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataUpdateSuccess,
					HttpStatus.ACCEPTED, customerAddress);
		} catch (Exception e) {
			System.out.println("Inside Catch : UpdateAddress");
			e.printStackTrace();
			// TODO: handle exception

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataUpdateFailed,
					HttpStatus.NOT_MODIFIED, e);
		}
	}

	@DeleteMapping("/customerAddress/{customerAddressId}")
	public ResponseEntity<RequestResponse> deleteCustomerAddress(
			@PathVariable("customerAddressId") Long customerAddressId) {
		System.out.println("Customer Address Delete Hitted : Id : " + customerAddressId);

		CustomerAddress deleteAddress = this.customerAddressService.findByCustomerAddressId(customerAddressId);
		deleteAddress.setStatus(true);

		this.customerAddressService.updateCustomerAddress(deleteAddress, customerAddressId);

		return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataDeleteSuccess, HttpStatus.ACCEPTED,
				deleteAddress);
	}

	@GetMapping("/customerAddresses/customerMasterId/{customerMasterId}")
	public ResponseEntity<RequestResponse> getCustomerAddressByCustomerIdWise(
			@PathVariable("customerMasterId") Long customerMasterId) {
		System.out.println("customerMasterId====>>>"+customerMasterId);
		List<CustomerAddress> customerAddressList = customerAddressService
				.getCustomerAddressByCustomerMasterId(customerMasterId);
		System.out.println("customerAddressList====>>>"+customerAddressList);
		if (customerAddressList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.OK,
					null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED,
					customerAddressList.stream()
							.filter(ca -> ca.getStatus() == false && ca.getAddressType().equals("Permanent"))
							.collect(Collectors.toList()));
		}
	}
	
}
