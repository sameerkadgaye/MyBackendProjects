/**
 * 
 */
package com.practice.controller.admin.masters.customerMaster;

import java.util.List;

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
import com.practice.model.admin.masters.customerMaster.CustomerBankDetails;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;
import com.practice.model.common.RequestResponse;
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

@RestController
@CrossOrigin
@RequestMapping("/master")
public class CustomerBankDetailsController {

	@Autowired
	private CustomerBankDetailsService customerBankDetailsService;

	@GetMapping("/customerBankDetailsList")
	public ResponseEntity<RequestResponse> getCustomerBank() {
		List<CustomerBankDetails> customerBankDetailsList = customerBankDetailsService
				.findCustomerBankDetailsByBankStatus();

		if (customerBankDetailsList.size() <= 0)
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.OK,
					null);
		else
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, customerBankDetailsList);
	}

	@GetMapping("/customerBankDetails/{customerBankDetailsId}")
	public ResponseEntity<RequestResponse> getCustomerBankDetailsId(
			@PathVariable("customerBankDetailsId") Long customerBankDetailsId) {
		CustomerBankDetails customerBankDetails = customerBankDetailsService
				.findByCustomerBankDetailsId(customerBankDetailsId);

		if (customerBankDetails == null)
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					null);
		else
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, customerBankDetails);
	}

	@PostMapping("/customerBankDetails/{customerBankDetailsId}")
	public ResponseEntity<RequestResponse> saveCustomerBankDetails(
			@PathVariable("customerBankDetailsId") CustomerMaster customerId,
			@RequestBody CustomerBankDetails customerBankDetails) {
		System.out.println("Customer Bank Details Save Hitted : " + customerBankDetails);

		try {
			customerBankDetails.setBankStatus(false);
			customerBankDetails.setCustomerMaster(customerId);

			CustomerBankDetails savedBankDetails = this.customerBankDetailsService
					.saveCustomerBankDetails(customerBankDetails);
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
					savedBankDetails);
		} catch (Exception e) {
			System.out.println("Inside Catch : SaveBankDetails");
			e.printStackTrace();
			// TODO: handle exception

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveFailed,
					HttpStatus.NOT_MODIFIED, e);
		}
	}

	@PostMapping("/customerBankDetailsList")
	public ResponseEntity<RequestResponse> saveListCustomerAddress(
			@RequestBody List<CustomerBankDetails> savedBankDetails) {
		System.out.println("Customer Bank Details List Save Hitted : " + savedBankDetails);

		try {
			this.customerBankDetailsService.saveCustomerBankDetailsList(savedBankDetails);
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
					savedBankDetails);
		} catch (Exception e) {
			System.out.println("Inside Catch : SaveBankDetailsList");
			e.printStackTrace();
			// TODO: handle exception

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveFailed,
					HttpStatus.NOT_MODIFIED, e);
		}
	}

	@PutMapping("/customerBankDetails/{customerBankDetailsId}")
	public ResponseEntity<RequestResponse> updateCustomerBankDetails(
			@PathVariable("customerBankDetailsId") Long customerBankDetailsId) {
		System.out.println("Customer Bank Details Update Hitted : Id : " + customerBankDetailsId);

		try {
			CustomerBankDetails customerBankDetails = this.customerBankDetailsService
					.findByCustomerBankDetailsId(customerBankDetailsId);

			customerBankDetails.setBankStatus(true);
			customerBankDetails.setCustomerMaster(null);

			this.customerBankDetailsService.updateCustomerBankDetails(customerBankDetails, customerBankDetailsId);
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataUpdateSuccess,
					HttpStatus.ACCEPTED, customerBankDetails);
		} catch (Exception e) {
			System.out.println("Inside Catch : UpdateBankDetails");
			e.printStackTrace();
			// TODO: handle exception

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataUpdateFailed,
					HttpStatus.NOT_MODIFIED, e);
		}
	}

	@DeleteMapping("/customerBankDetails/{customerBankDetailsId}")
	public ResponseEntity<RequestResponse> deleteCustomerAddress(
			@PathVariable("customerBankDetailsId") Long customerBankDetailsId) {
		System.out.println("Customer Bank Details Delete Hitted : Id : " + customerBankDetailsId);

		CustomerBankDetails deleteBankDetails = this.customerBankDetailsService
				.findByCustomerBankDetailsId(customerBankDetailsId);
		deleteBankDetails.setBankStatus(true);

		this.customerBankDetailsService.updateCustomerBankDetails(deleteBankDetails, customerBankDetailsId);

		return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataDeleteSuccess, HttpStatus.ACCEPTED,
				deleteBankDetails);
	}

}
