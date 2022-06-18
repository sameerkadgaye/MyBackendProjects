/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.loan;

import com.practice.model.admin.acOpenings.loan.LoanDetails;

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

public interface LoanDetailsService {

//	Method To Get Loan Details By Id
	LoanDetails getLoanDetailsById(Long loanDetailsId);

//	Method To Save And Update Loan Details
	LoanDetails saveUpdateLoanDetailsForm(LoanDetails loanDetails);

//	Method To Update Loan Details
	LoanDetails updateLoanDetailsForm(LoanDetails loanDetails);

//	Method To Delete Loan Details
	LoanDetails deleteLoanDetails(LoanDetails loanDetails);

}
