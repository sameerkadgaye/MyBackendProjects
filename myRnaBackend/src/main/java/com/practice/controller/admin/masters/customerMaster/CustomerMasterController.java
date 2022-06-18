/**
 * 
 */
package com.practice.controller.admin.masters.customerMaster;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.component.CustomerFileUploadHelper;
import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.deposit.DepositAccountService;
import com.practice.service.inf.admin.masters.customerMaster.CustomerMasterService;
import com.practice.util.AllUtils;

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

@RestController
@CrossOrigin
@RequestMapping("/master")
public class CustomerMasterController {

	@Autowired
	private CustomerMasterService customerMasterService;

	@Autowired
	private DepositAccountService depositAccountService;

	@Autowired
	private CustomerFileUploadHelper customerFileUploadHelper;

	/**
	 * 
	 */
	public CustomerMasterController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/customers")
	public ResponseEntity<RequestResponse> getCustomerMaster() {
		List<CustomerMaster> customerList = this.customerMasterService.findCustomerByStatus();
		if (customerList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, customerList);
		}
	}

//	@GetMapping("/customerAddresses")
//	public ResponseEntity<RequestResponse> getCustomerAddress() {
//		List<CustomerAddress> customerAddressList = this.customerAddressService.findCustomerAddressByStatus();
//		if (customerAddressList.size() <= 0) {
//			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
//					HttpStatus.NOT_FOUND, null);
//		} else {
//			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
//					HttpStatus.ACCEPTED, customerAddressList);
//		}
//	}

	@GetMapping("/customer/{customerMasterId}")
	public ResponseEntity<RequestResponse> getCustomerMasterById(
			@PathVariable("customerMasterId") Long customerMasterId) {
		CustomerMaster customer = this.customerMasterService.getCustomerMasterById(customerMasterId);
		if (customer == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					customer);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				customer);
	}

	@GetMapping("/customer/customerCode/{customerCode}")
	public ResponseEntity<RequestResponse> getCustomerMasterByCustomerCode(
			@PathVariable("customerCode") Long customerCode) {
		CustomerMaster customer = this.customerMasterService.findByCustomerCode(customerCode);
		if (customer == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					customer);
		} else {
			System.out.println("customer.isStatus() ==> " + customer.isStatus());
			if (!customer.isStatus()) {
				System.out.println("Hey If =======>>>> " + customer.isStatus());
				return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
						HttpStatus.ACCEPTED, customer);
			} else {
				customer = null;
				return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound,
						HttpStatus.NOT_FOUND, customer);
			}
		}
	}

//	@GetMapping("/customerAddress/{customerAddressId}")
//	public ResponseEntity<RequestResponse> getCustomerAddressById(
//
//			@PathVariable("customerAddressId") Long customerAddressId) {
//		CustomerAddress customerAddress = this.customerAddressService.findByCustomerAddressId(customerAddressId);
//		if (customerAddress == null) {
//			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
//					customerAddress);
//		}
//		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
//				customerAddress);
//	}

	@PostMapping("/customerDetails")
	public ResponseEntity<RequestResponse> saveCustomerMaster(@RequestBody CustomerMaster customer) {
		System.out.println("Save Mapping Heated ===>>" + customer);
		try {
			if (this.customerMasterService.getMaxCustomerCode() == null) {
				customer.setStatus(false);
				customer.setIpAddress(AllUtils.getIpAddress());
				customer.setMacAddress(AllUtils.getMacAddress());
				customer.setEnterBy(AllUtils.getSystemName());
				customer.setEnterDate(new Date());
//				customer.setCustomerCode((long) 100000);
				customer.setCustomerCode((long) 1);
				CustomerMaster savedCustomer = this.customerMasterService.saveCustomerMaster(customer);
				System.out.println("Saved Customer : " + savedCustomer);
				return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess,
						HttpStatus.CREATED, savedCustomer);
			} else {
				customer.setStatus(false);
				customer.setIpAddress(AllUtils.getIpAddress());
				customer.setMacAddress(AllUtils.getMacAddress());
				customer.setEnterBy(AllUtils.getSystemName());
				customer.setEnterDate(new Date());
				customer.setCustomerCode(this.customerMasterService.getMaxCustomerCode());
				CustomerMaster savedCustomer = this.customerMasterService.saveCustomerMaster(customer);
				System.out.println("Saved Customer : " + savedCustomer);
				return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess,
						HttpStatus.CREATED, savedCustomer);
			}
		} catch (Exception e) {
			System.out.println("Inside Catch ===>>>>> ");
			e.printStackTrace();
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveFailed,
					HttpStatus.NOT_MODIFIED, customer);
		}
	}

	@PostMapping("/customerSignature/{customerId}")
	public ResponseEntity<String> saveCustomerMasterSignature(@PathVariable("customerId") Long customerId,
			@RequestParam MultipartFile file, @RequestParam String signatureFileType) {
		System.out.println("Signature Save Hitted!!!");
		System.out.println("Customer Id : " + customerId);

		System.out.println("File Original Name : " + file.getOriginalFilename());
		System.out.println("File Type : " + file.getContentType());
		System.out.println("File Name : " + file.getName());
		System.out.println("Type : " + signatureFileType);

		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Select File First For Upload");
			}

			/* File Upload Code */
			 boolean status = customerFileUploadHelper.uploadSignature(file);

			if (status) {
				String filePath = ServletUriComponentsBuilder.fromCurrentContextPath()
						.path("/documents/customerSignature/").path(file.getOriginalFilename()).toUriString();

				CustomerMaster customerRecord = this.customerMasterService.getCustomerMasterById(customerId);

				CustomerMaster customer = new CustomerMaster();
				customer.setCustomerCode(customerRecord.getCustomerCode());
				customer.setCustomerCreationDate(customerRecord.getCustomerCreationDate());
				customer.setMemberMaritalTitle(customerRecord.getMemberMaritalTitle());
				customer.setFirstName(customerRecord.getFirstName());
				customer.setMiddleName(customerRecord.getMiddleName());
				customer.setLastName(customerRecord.getLastName());
				customer.setGender(customerRecord.getGender());
				customer.setMobileNo(customerRecord.getMobileNo());
				customer.setDateOfBirth(customerRecord.getDateOfBirth());
				customer.setAdhaarNo(customerRecord.getAdhaarNo());
				customer.setOccupation(customerRecord.getOccupation());
				customer.setPanNo(customerRecord.getPanNo());
				customer.setEducation(customerRecord.getEducation());
				customer.setVoterIdNo(customerRecord.getVoterIdNo());
				customer.setRationCardNo(customerRecord.getRationCardNo());
				customer.setSignatureFileName(file.getOriginalFilename());
				customer.setSignatureFileType(signatureFileType);
				customer.setSignatureFilePath(filePath);
				customer.setSignatureFileContentType(file.getContentType());
				customer.setPhotoFileName(customerRecord.getPhotoFileName());
				customer.setPhotoFileType(customerRecord.getPhotoFileType());
				customer.setPhotoFilePath(customerRecord.getPhotoFilePath());
				customer.setPhotoFileContentType(customerRecord.getPhotoFileContentType());

				this.customerMasterService.saveCustomerMasterSignature(customer, customerId);

				System.out.println("Customer Signature Saved Successfully!!!");

				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
						.path("/documents/customerSignature/").path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Something Went To Wrong !! Please Try Again Letter");
	}

	@PostMapping("/customerPhoto/{customerId}")
	public ResponseEntity<String> saveCustomerMasterPhoto(@PathVariable("customerId") Long customerId,
			@RequestParam MultipartFile file, @RequestParam String photoFileType) {
		System.out.println("Photo Save Hitted!!!");
		System.out.println("Customer Id : " + customerId);

		System.out.println("File Original Name : " + file.getOriginalFilename());
		System.out.println("File Type : " + file.getContentType());
		System.out.println("File Name : " + file.getName());
		System.out.println("Type : " + photoFileType);

		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Select File First For Upload");
			}
			/* File Upload Code */
			// This End Point Is Responsible For File Handling for Jasper And Image File
			// Handle Due Some Linux system path Error I Comment this
			// Bellow Please Uncomment This line below as well as CustomerFileUploadHelper class methods
			// Before used For Now I passed false value in status
			// onces u uncomment below line then please remove hardcoded false value for
			// status -> Comment add by Sameer Kadgaye.

			// boolean status = customerFileUploadHelper.uploadPhoto(file);
			boolean status = false;

			if (status) {
				String filePath = ServletUriComponentsBuilder.fromCurrentContextPath().path("/documents/customerPhoto/")
						.path(file.getOriginalFilename()).toUriString();

				CustomerMaster customerRecord = this.customerMasterService.getCustomerMasterById(customerId);

				CustomerMaster customer = new CustomerMaster();
				customer.setCustomerCode(customerRecord.getCustomerCode());
				customer.setCustomerCreationDate(customerRecord.getCustomerCreationDate());
				customer.setMemberMaritalTitle(customerRecord.getMemberMaritalTitle());
				customer.setFirstName(customerRecord.getFirstName());
				customer.setMiddleName(customerRecord.getMiddleName());
				customer.setLastName(customerRecord.getLastName());
				customer.setGender(customerRecord.getGender());
				customer.setMobileNo(customerRecord.getMobileNo());
				customer.setDateOfBirth(customerRecord.getDateOfBirth());
				customer.setAdhaarNo(customerRecord.getAdhaarNo());
				customer.setOccupation(customerRecord.getOccupation());
				customer.setPanNo(customerRecord.getPanNo());
				customer.setEducation(customerRecord.getEducation());
				customer.setVoterIdNo(customerRecord.getVoterIdNo());
				customer.setRationCardNo(customerRecord.getRationCardNo());
				customer.setSignatureFileName(customerRecord.getSignatureFileName());
				customer.setSignatureFileType(customerRecord.getSignatureFileType());
				customer.setSignatureFilePath(customerRecord.getSignatureFilePath());
				customer.setSignatureFileContentType(customerRecord.getSignatureFileContentType());
				customer.setPhotoFileName(file.getOriginalFilename());
				customer.setPhotoFileType(photoFileType);
				customer.setPhotoFilePath(filePath);
				customer.setPhotoFileContentType(file.getContentType());

				this.customerMasterService.saveCustomerMasterPhoto(customer, customerId);

				System.out.println("Customer Photo Saved Successfully!!!");

				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
						.path("/documents/customerPhoto/").path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Something Went To Wrong !! Please Try Again Letter");
	}

	@PutMapping("/customer/{customerMasterId}")
	public ResponseEntity<RequestResponse> updateCustomerMaster(@RequestBody CustomerMaster customer,
			@PathVariable("customerMasterId") Long customerMasterId) {
		CustomerMaster updateCustomer = this.customerMasterService.getCustomerMasterById(customerMasterId);

		customer.setCustomerCreationDate(updateCustomer.getCustomerCreationDate());
		customer.setCustomerCode(updateCustomer.getCustomerCode());
		customer.setEnterBy(updateCustomer.getEnterBy());
		customer.setEnterDate(updateCustomer.getEnterDate());
		customer.setIpAddress(updateCustomer.getIpAddress());
		customer.setMacAddress(updateCustomer.getMacAddress());
		customer.setUsername(updateCustomer.getUsername());
		customer.setSignatureFileContentType(updateCustomer.getSignatureFileContentType());
		customer.setSignatureFileName(updateCustomer.getSignatureFileName());
		customer.setSignatureFilePath(updateCustomer.getSignatureFilePath());
		customer.setPhotoFileContentType(updateCustomer.getPhotoFileContentType());
		customer.setPhotoFileName(updateCustomer.getPhotoFileName());
		customer.setPhotoFilePath(updateCustomer.getPhotoFilePath());
		this.customerMasterService.updateCustomerMaster(customer, customerMasterId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,
				customer);
	}

	@DeleteMapping("/customer/{customerMasterId}")
	public ResponseEntity<RequestResponse> deletecustomerMaster(
			@PathVariable("customerMasterId") Long customerMasterId) {
		System.out.println("Delete Mapping Heated ===>>" + customerMasterId);
		CustomerMaster customer = this.customerMasterService.getCustomerMasterById(customerMasterId);
		customer.setStatus(true);

		Long customerCode = customer.getCustomerCode();

		List<DepositAccount> depositAccounts = this.depositAccountService
				.getCustomerCodeWiseDepositAccount(customerCode);
		// Main If Deposit Account Starts
		if (depositAccounts.size() != 0) {
			depositAccounts.forEach(da -> {
				da.setStatus(true);
				try {
					da.setIpAddress(AllUtils.getIpAddress());
					da.setMacAddress(AllUtils.getMacAddress());
					da.setEnterDate(new Date());
					Optional<String> enterBy = Optional.ofNullable(customer.getEnterBy());
					da.setEnterBy(enterBy.orElse(AllUtils.getSystemName()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			this.depositAccountService.updateDepositAccountList(depositAccounts);
		}

		// Main If Deposit Account Ends

		this.customerMasterService.updateCustomerMaster(customer, customerMasterId);
		// this.customerMasterService.deleteCustomerMaster(customerMasterId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess,
				HttpStatus.NO_CONTENT, null);
	}
}
