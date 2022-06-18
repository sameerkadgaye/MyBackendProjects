/**
 * 
 */
package com.practice.controller.admin.acOpenings.loan;

import java.util.List;

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
import com.practice.dao.admin.acOpenings.loan.LoanGuarantorDetailsRepository;
import com.practice.model.admin.acOpenings.loan.LoanAccount;
import com.practice.model.admin.acOpenings.loan.LoanGuarantorDetails;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.loan.LoanGuarantorDetailsService;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 03/02/2022
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/master")
public class LoanGuarantorDetailsController {

	@Autowired
	private LoanGuarantorDetailsRepository loanGuarantorDetailsRepository;

	@Autowired
	private LoanGuarantorDetailsService loanGuarantorDetailsService;

	@PostMapping("/saveUpdateLoanGuarantorDetails/{loanAccountId}")
	public ResponseEntity<RequestResponse> saveUpdateGuarantorDetailsForm(@PathVariable LoanAccount loanAccountId,
			@RequestBody LoanGuarantorDetails loanGuarantorDetails) {
		loanGuarantorDetails.setLoanAccount(loanAccountId);
		loanGuarantorDetails.setStatus(false);

		List<LoanGuarantorDetails> guarantorDetails = this.loanGuarantorDetailsService.getAllLoanGuarantorDetails();

		if (guarantorDetails.size() != 0) {
			System.out.println("guarantorDetails : " + guarantorDetails);

			guarantorDetails.forEach((detail) -> {
				System.out.println("detail : " + detail);

				detail.setLoanAccount(null);
				detail.setStatus(true);
				this.loanGuarantorDetailsService.updateLoanGuarantorDetailsForm(detail);
			});
		}

		LoanGuarantorDetails savedLoanGuarantorDetails = this.loanGuarantorDetailsService
				.saveUpdateLoanGuarantorDetailsForm(loanGuarantorDetails);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
				HttpStatus.ACCEPTED, savedLoanGuarantorDetails);
	}

	@PutMapping("/updateLoanGuarantorDetails/{loanGuarantorDetailsId}")
	public ResponseEntity<RequestResponse> updateGuarantorDetailsForm(@PathVariable Long loanGuarantorDetailsId) {
		LoanGuarantorDetails loanGuarantorDetails = this.loanGuarantorDetailsService
				.getLoanGuarantorDetailsById(loanGuarantorDetailsId);

		loanGuarantorDetails.setLoanAccount(null);
		loanGuarantorDetails.setStatus(true);

		LoanGuarantorDetails updatedLoanGuarantorDetails = this.loanGuarantorDetailsService
				.updateLoanGuarantorDetailsForm(loanGuarantorDetails);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
				HttpStatus.ACCEPTED, updatedLoanGuarantorDetails);
	}

	@DeleteMapping("/deleteLoanGuarantorDetails/{loanGuarantorDetailsId}")
	public ResponseEntity<RequestResponse> deleteGuarantorDetails(@PathVariable Long loanGuarantorDetailsId) {
		LoanGuarantorDetails loanGuarantorDetails = this.loanGuarantorDetailsService
				.getLoanGuarantorDetailsById(loanGuarantorDetailsId);

		loanGuarantorDetails.setStatus(true);

		LoanGuarantorDetails deletedLoanGuarantorDetails = this.loanGuarantorDetailsService
				.deleteLoanGuarantorDetails(loanGuarantorDetails);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess,
				HttpStatus.ACCEPTED, deletedLoanGuarantorDetails);
	}

}
