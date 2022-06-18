/**
 * 
 */
package com.practice.controller.admin.acOpenings.loan;

import java.net.SocketException;
import java.net.UnknownHostException;

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
import com.practice.dao.admin.acOpenings.loan.LoanDetailsRepository;
import com.practice.model.admin.acOpenings.loan.LoanAccount;
import com.practice.model.admin.acOpenings.loan.LoanDetails;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.loan.LoanAccountService;
import com.practice.service.inf.admin.acOpenings.loan.LoanDetailsService;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 01/02/2022
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/master")
public class LoanDetailsController {

	@Autowired
	private LoanDetailsRepository loanDetailsRepository;

	@Autowired
	private LoanDetailsService loanDetailsService;

	@Autowired
	private LoanAccountService loanAccountService;

	@GetMapping("/loanDetailsById/{loanDetailsId}")
	public ResponseEntity<RequestResponse> getLoanDetailsById(@PathVariable Long loanDetailsId) {
		LoanDetails loanDetails = this.loanDetailsService.getLoanDetailsById(loanDetailsId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				loanDetails);
	}

//	@PostMapping("/saveUpdateLoanDetails/{loanAccountId}")
//	public ResponseEntity<RequestResponse> saveUpdateLoanDetailsForm(@PathVariable LoanAccount loanAccountId,
//			@RequestBody LoanDetails loanDetails) {
//		loanDetails.setLoanAccount(loanAccountId);
//		loanDetails.setStatus(false);
//
//		System.out.println("loanDetails : " + loanDetails);
//
////		LoanDetails savedLoanDetails = this.loanDetailsService.saveUpdateLoanDetailsForm(loanDetails);
//
//		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
//				HttpStatus.ACCEPTED, loanDetails);
//	}

	@PostMapping("/saveUpdateLoanDetails/{loanAccountId}")
	public ResponseEntity<RequestResponse> saveUpdateLoanDetailsForm(@PathVariable LoanAccount loanAccountId,
			@RequestBody LoanDetails loanDetails) throws UnknownHostException, SocketException {
		loanDetails.setStatus(false);

//		LoanDetails savedLoanDetails = this.loanDetailsService.saveUpdateLoanDetailsForm(loanDetails);
//		LoanAccount loanAccountById = this.loanAccountService
//				.getLoanAccountById(savedLoanDetails.getLoanAccount().getLoanAccountId());

//		loanDetails.setLoanAccount(loanAccountById);

//		System.out.println("loanAccountById : " + loanAccountById);

		if (loanDetails.getLoanDetailsId() == null) {
			System.out.println("Loan Account Loan Id Not Exist  ========>>> " + loanDetails.getLoanDetailsId());
			// Setting Newly saved Loan Account Data Into Loan Account Starts
			LoanDetails savedLoanDetails = this.loanDetailsService.saveUpdateLoanDetailsForm(loanDetails);
			if (savedLoanDetails != null) {
				if (savedLoanDetails.getLoanAccount().getLoanAccountId() != null) {
					LoanAccount loanAccountById = this.loanAccountService
							.getLoanAccountById(savedLoanDetails.getLoanAccount().getLoanAccountId());
					if (loanAccountById != null) {
						System.out.println("Loan Account Not Found!!!");
						loanAccountById.setLoanDetails(savedLoanDetails);
						this.loanAccountService.saveLoanAccount(loanAccountById);
					}
				}
			}
			// Setting Newly saved Loan Account Data Into Loan Account Ends
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess,
					HttpStatus.CREATED, savedLoanDetails);
		} else {
			System.out.println("Loan Account Loan Id If Exist========>>> " + loanDetails.getLoanDetailsId());
			LoanDetails updatedLoanDetails = this.loanDetailsService.saveUpdateLoanDetailsForm(loanDetails);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
					HttpStatus.CREATED, updatedLoanDetails);
		}
	}

	@PutMapping("/updateLoanDetails/{loanDetailsId}")
	public ResponseEntity<RequestResponse> updateLoanDetailsForm(@PathVariable Long loanDetailsId) {
		LoanDetails loanDetails = this.loanDetailsService.getLoanDetailsById(loanDetailsId);

		loanDetails.setLoanAccount(null);
		loanDetails.setStatus(true);

		LoanDetails updatedLoanDetails = this.loanDetailsService.updateLoanDetailsForm(loanDetails);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
				HttpStatus.ACCEPTED, updatedLoanDetails);
	}

	@DeleteMapping("/deleteLoanDetails/{loanDetailsId}")
	public ResponseEntity<RequestResponse> deleteLoanDetails(@PathVariable Long loanDetailsId) {
		LoanDetails loanDetails = this.loanDetailsService.getLoanDetailsById(loanDetailsId);

		loanDetails.setStatus(true);

		LoanDetails deletedLoanDetails = this.loanDetailsService.deleteLoanDetails(loanDetails);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess,
				HttpStatus.ACCEPTED, deletedLoanDetails);
	}

}
