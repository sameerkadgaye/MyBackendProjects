/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.loan;

import com.practice.model.admin.acOpenings.loan.LoanOperatorDetails;

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

public interface LoanOperatorDetailsService {

//	Method To Get Loan Operator Details By Id
	LoanOperatorDetails getLoanOperatorDetailsById(Long loanOperatorDetailsId);

//	Method To Save And Update Loan Operator Details
	LoanOperatorDetails saveUpdateOperatorDetailsForm(LoanOperatorDetails loanOperatorDetails);

//	Method To Update Loan Operator Details
	LoanOperatorDetails updateOperatorDetailsForm(LoanOperatorDetails loanOperatorDetails);

//	Method To Delete Loan Operator Details
	LoanOperatorDetails deleteOperatorDetails(LoanOperatorDetails loanOperatorDetails);

}
