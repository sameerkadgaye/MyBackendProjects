/**
 * 
 */
package com.practice.controller.admin.acOpenings.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.dao.admin.acOpenings.loan.LoanOperatorDetailsRepository;
import com.practice.model.admin.acOpenings.loan.LoanOperatorDetails;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.loan.LoanOperatorDetailsService;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 31/01/2022
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/master")
public class LoanOperatorDetailsController {

	@Autowired
	private LoanOperatorDetailsRepository loanOperatorDetailsRepository;

	@Autowired
	private LoanOperatorDetailsService loanOperatorDetailsService;

	@PostMapping("/saveUpdateLoanOperatorDetails")
	public ResponseEntity<RequestResponse> saveUpdateOperatorDetailsForm(
			@RequestBody LoanOperatorDetails loanOperatorDetails) {
//		loanOperatorDetails.setLoanAccount(loanAccountId);
		loanOperatorDetails.setLoanOperatorStatus(false);

		LoanOperatorDetails savedLoanOperatorDetails = this.loanOperatorDetailsService
				.saveUpdateOperatorDetailsForm(loanOperatorDetails);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
				HttpStatus.ACCEPTED, savedLoanOperatorDetails);
	}

	@PutMapping("/updateLoanOperatorDetails/{loanOperatorDetailsId}")
	public ResponseEntity<RequestResponse> updateOperatorDetailsForm(@PathVariable Long loanOperatorDetailsId) {
		LoanOperatorDetails loanOperatorDetails = this.loanOperatorDetailsService
				.getLoanOperatorDetailsById(loanOperatorDetailsId);

		loanOperatorDetails.setLoanAccount(null);
		loanOperatorDetails.setLoanOperatorStatus(true);

		LoanOperatorDetails updatedLoanOperatorDetails = this.loanOperatorDetailsService
				.updateOperatorDetailsForm(loanOperatorDetails);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
				HttpStatus.ACCEPTED, updatedLoanOperatorDetails);
	}

	@DeleteMapping("/deleteLoanOperatorDetails/{loanOperatorDetailsId}")
	public ResponseEntity<RequestResponse> deleteOperatorDetails(@PathVariable Long loanOperatorDetailsId) {
		LoanOperatorDetails loanOperatorDetails = this.loanOperatorDetailsService
				.getLoanOperatorDetailsById(loanOperatorDetailsId);

		loanOperatorDetails.setLoanOperatorStatus(true);

		LoanOperatorDetails deletedLoanOperatorDetails = this.loanOperatorDetailsService
				.deleteOperatorDetails(loanOperatorDetails);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess,
				HttpStatus.ACCEPTED, deletedLoanOperatorDetails);
	}

}
