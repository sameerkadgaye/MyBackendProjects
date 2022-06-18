/**
 * 
 */
package com.practice.controller.admin.masters.customerMaster;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
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
import com.practice.dao.admin.masters.customerMaster.CustomerKycDetailsRepository;
import com.practice.model.admin.masters.customerMaster.CustomerKycDetails;
import com.practice.model.common.RequestResponse;
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

@RestController
@CrossOrigin
@RequestMapping("/master")
public class CustomerKycDetailsController {

	@Autowired
	private CustomerKycDetailsService customerKycDetailsService;

	@Autowired
	private CustomerKycDetailsRepository customerKycDetailsRepository;

	@Autowired
	private CustomerFileUploadHelper customerFileUploadHelper;

	public CustomerKycDetailsController() {
	}

	@GetMapping("/customerKycDetails")
	public ResponseEntity<RequestResponse> getcustomerKycDetails() {
		List<CustomerKycDetails> customerKycDetailsList = customerKycDetailsService.findCustomerKycDetailsByStatus();

		if (customerKycDetailsList.size() <= 0)
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NO_CONTENT, null);
		else
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, customerKycDetailsList);
	}

	@GetMapping("/allCustomerKycDetails")
	public ResponseEntity<RequestResponse> getAllCustomerKycDetails() {
		List<CustomerKycDetails> customerKycDetailsList = customerKycDetailsRepository.findAll();

		if (customerKycDetailsList.size() <= 0)
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NO_CONTENT, null);
		else
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, customerKycDetailsList);
	}

	@GetMapping("/customerKycDetails/{customerKycDetailsId}")
	public ResponseEntity<RequestResponse> getCustomerKycDetailsById(
			@PathVariable("customerKycDetailsId") Long customerKycDetailsId) {
		CustomerKycDetails customerKycDetails = customerKycDetailsService
				.findByCustomerKycDetailsId(customerKycDetailsId);

		if (customerKycDetails == null)
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					null);
		else
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, customerKycDetails);
	}

	@GetMapping("/customerKycDetails/{documentFileName}")
	public ResponseEntity<RequestResponse> getCustomerKycDetailsByDocumentFileName(
			@PathVariable("documentFileName") String documentFileName) {
		CustomerKycDetails customerKycDetails = customerKycDetailsRepository
				.findCustomerKycDetailsByDocumentFileName(documentFileName);

		if (customerKycDetails == null)
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					null);
		else
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, customerKycDetails);
	}

	@PostMapping("/customerKycDetails")
	public ResponseEntity<RequestResponse> saveCustomerKycDetails(@RequestBody CustomerKycDetails customerKycDetails) {
		System.out.println("Customer Kyc Details Save Hitted : " + customerKycDetails);

		try {
			customerKycDetails.setStatus(false);

			CustomerKycDetails savedKycDetails = this.customerKycDetailsService
					.saveCustomerKycDetails(customerKycDetails);
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
					savedKycDetails);
		} catch (Exception e) {
			System.out.println("Inside Catch : SaveKycDetails");
			e.printStackTrace();

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveFailed,
					HttpStatus.NOT_MODIFIED, e);
		}
	}

	@PostMapping("/customerKycDetailsList")
	public ResponseEntity<RequestResponse> saveListCustomerKycDetails(@RequestBody List<CustomerKycDetails> customerKyc)
			throws JSONException {
		System.out.println("customerKyc : " + customerKyc);
		System.out.println("Customer KYC Details List Save Hitted : " + customerKyc);

		try {
			List<CustomerKycDetails> savedCustomerKycDetailsList = this.customerKycDetailsService
					.saveCustomerKycDetailsList(customerKyc);

			System.out.println("savedCustomerKycDetailsList : " + savedCustomerKycDetailsList);

			Long[] customerKycDetailsId = new Long[savedCustomerKycDetailsList.size()];

			for (int i = 0; i < savedCustomerKycDetailsList.size(); i++) {
				customerKycDetailsId[i] = savedCustomerKycDetailsList.get(i).getCustomerKycDetailsId();

				System.out.println("customerKycDetailsId : " + customerKycDetailsId[i]);

				System.out.println("savedCustomerKycDetailsList : "
						+ savedCustomerKycDetailsList.get(i).getCustomerKycDetailsId());
			}

			System.out.println("customerKycDetailsId Array : " + Arrays.toString(customerKycDetailsId));

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
					customerKycDetailsId);
		} catch (Exception e) {
			System.out.println("Inside Catch : SaveKycDetailsList");
			e.printStackTrace();

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataSaveFailed,
					HttpStatus.NOT_MODIFIED, e);
		}

	}

	@PostMapping(path = "/customerKycDocumentsList/{documentId}"/* , consumes = "multipart/form-data" */)
	public ResponseEntity<String> saveListCustomerKycDocuments(@PathVariable("documentId") Long documentId,
			@RequestParam MultipartFile file) throws IOException {
		System.out.println("Customer KYC Documents Save Hitted!!!");
		System.out.println("documentId : " + documentId);

		System.out.println("File Original Name : " + file.getOriginalFilename());
		System.out.println("File Type : " + file.getContentType());
		System.out.println("File Name : " + file.getName());

		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Select File First For Upload");
			}

			/* File Upload Code */
			boolean status = customerFileUploadHelper.uploadDocument(file);

			if (status) {
				String filePath = ServletUriComponentsBuilder.fromCurrentContextPath()
						.path("/documents/customerDocuments/").path(file.getOriginalFilename()).toUriString();

				CustomerKycDetails kycDetails = this.customerKycDetailsService.findByCustomerKycDetailsId(documentId);

				CustomerKycDetails customer = new CustomerKycDetails();
				customer.setCustomerMaster(kycDetails.getCustomerMaster());
				customer.setIdCustomerMaster(kycDetails.getIdCustomerMaster());
				customer.setDocumentType(kycDetails.getDocumentType());
				customer.setDocumentDetails(kycDetails.getDocumentDetails());
				customer.setDocumentNo(kycDetails.getDocumentNo());
				customer.setOtherDocumentDetail(kycDetails.getOtherDocumentDetail());
				customer.setExpiryDate(kycDetails.getExpiryDate());
				customer.setCertifiedBy(kycDetails.getCertifiedBy());
				customer.setCompulsoryFlag(kycDetails.getCompulsoryFlag());
				customer.setDocumentFileName(file.getOriginalFilename());
				customer.setDocumentFilePath(filePath);
				customer.setDocumentFileType(kycDetails.getDocumentFileType());

				this.customerKycDetailsService.saveCustomerKycFile(customer, documentId);

				System.out.println("Customer KYC Documents Saved Successfully!!!");

				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
						.path("/documents/customerDocuments/").path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Something Went To Wrong !! Please Try Again Letter");

	}

	@PutMapping("/customerKycDetails/{customerKycDetailsId}")
	public ResponseEntity<RequestResponse> updateCustomerKycDetails(
			@PathVariable("customerKycDetailsId") Long customerKycDetailsId) {
		System.out.println("Customer Kyc Details Update Hitted : Id : " + customerKycDetailsId);

		try {
			CustomerKycDetails kycDetails = this.customerKycDetailsService
					.findByCustomerKycDetailsId(customerKycDetailsId);

			kycDetails.setStatus(true);
			kycDetails.setCustomerMaster(null);

			this.customerKycDetailsService.updateCustomerKycDetails(kycDetails, customerKycDetailsId);
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataUpdateSuccess,
					HttpStatus.ACCEPTED, kycDetails);
		} catch (Exception e) {
			System.out.println("Inside Catch : UpdateKycDetails");
			e.printStackTrace();
			// TODO: handle exception

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataUpdateFailed,
					HttpStatus.NOT_MODIFIED, e);
		}
	}

	@PutMapping("/customerKycDocuments/{customerKycDetailsId}")
	public ResponseEntity<RequestResponse> updateCustomerKycDocuments(/* @RequestParam MultipartFile file, */
			@PathVariable("customerKycDetailsId") Long customerKycDetailsId) {
		System.out.println("Customer KYC Documents Save Hitted!!!");
		System.out.println("CustomerId : " + customerKycDetailsId);

		CustomerKycDetails kycDetails = this.customerKycDetailsService.findByCustomerKycDetailsId(customerKycDetailsId);

		kycDetails.setStatus(true);
		kycDetails.setCustomerMaster(null);

		this.customerKycDetailsService.updateCustomerKycDetails(kycDetails, customerKycDetailsId);

		System.out.println("Customer KYC Documents Updated Successfully!!!");
		return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataUpdateSuccess, HttpStatus.ACCEPTED,
				kycDetails);
	}

	@DeleteMapping("/customerKycDetails/{customerKycDetailsId}")
	public ResponseEntity<RequestResponse> deleteCustomerKycDetails(
			@PathVariable("customerKycDetailsId") Long customerKycDetailsId) {
		System.out.println("Customer Kyc Details Delete Hitted : Id : " + customerKycDetailsId);

		CustomerKycDetails deleteKycDetails = this.customerKycDetailsService
				.findByCustomerKycDetailsId(customerKycDetailsId);
		deleteKycDetails.setStatus(true);

		this.customerKycDetailsService.updateCustomerKycDetails(deleteKycDetails, customerKycDetailsId);

		return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataDeleteSuccess, HttpStatus.ACCEPTED,
				deleteKycDetails);
	}

	@DeleteMapping("/customerKycDocuments/{customerKycDetailsId}")
	public ResponseEntity<RequestResponse> deleteCustomerKycDocuments(
			@PathVariable("customerKycDetailsId") Long customerKycDetailsId) {
		System.out.println("Customer Kyc Documents Delete Hitted : Id : " + customerKycDetailsId);

		CustomerKycDetails deleteKycDocuments = this.customerKycDetailsService
				.findByCustomerKycDetailsId(customerKycDetailsId);
		deleteKycDocuments.setStatus(true);

		this.customerKycDetailsService.updateCustomerKycDetails(deleteKycDocuments, customerKycDetailsId);

		return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataDeleteSuccess, HttpStatus.ACCEPTED,
				deleteKycDocuments);
	}

}
