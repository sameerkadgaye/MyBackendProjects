/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.loan;

import java.util.List;

import com.practice.model.admin.acOpenings.loan.LoanGuarantorDetails;

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

public interface LoanGuarantorDetailsService {

//	Method To Get All Loan Guarantor Details Where Status is false
	List<LoanGuarantorDetails> getAllLoanGuarantorDetails();

//	Method To Get Loan Guarantor Details By Id
	LoanGuarantorDetails getLoanGuarantorDetailsById(Long loanGuarantorDetailsId);

//	Method To Save And Update Loan Guarantor Details
	LoanGuarantorDetails saveUpdateLoanGuarantorDetailsForm(LoanGuarantorDetails loanGuarantorDetails);

//	Method To Update Loan Guarantor Details
	LoanGuarantorDetails updateLoanGuarantorDetailsForm(LoanGuarantorDetails loanGuarantorDetails);

//	Method To Delete Loan Guarantor Details
	LoanGuarantorDetails deleteLoanGuarantorDetails(LoanGuarantorDetails loanGuarantorDetails);

}
