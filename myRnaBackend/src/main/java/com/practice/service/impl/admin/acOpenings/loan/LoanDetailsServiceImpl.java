/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.loan.LoanDetailsRepository;
import com.practice.model.admin.acOpenings.loan.LoanDetails;
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

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {

	@Autowired
	private LoanDetailsRepository loanDetailsRepository;

	@Override
	public LoanDetails getLoanDetailsById(Long loanDetailsId) {
		return this.loanDetailsRepository.findById(loanDetailsId).get();
	}

	@Override
	public LoanDetails saveUpdateLoanDetailsForm(LoanDetails loanDetails) {
		return this.loanDetailsRepository.save(loanDetails);
	}

	@Override
	public LoanDetails updateLoanDetailsForm(LoanDetails loanDetails) {
		return this.loanDetailsRepository.save(loanDetails);
	}

	@Override
	public LoanDetails deleteLoanDetails(LoanDetails loanDetails) {
		return this.loanDetailsRepository.save(loanDetails);
	}

}
