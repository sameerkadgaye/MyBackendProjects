/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.loan.LoanOperatorDetailsRepository;
import com.practice.model.admin.acOpenings.loan.LoanOperatorDetails;
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

@Service
public class LoanOperatorDetailsServiceImpl implements LoanOperatorDetailsService {

	@Autowired
	private LoanOperatorDetailsRepository loanOperatorDetailsRepository;

	@Override
	public LoanOperatorDetails getLoanOperatorDetailsById(Long loanOperatorDetailsId) {
		return this.loanOperatorDetailsRepository.findById(loanOperatorDetailsId).get();
	}

	@Override
	public LoanOperatorDetails saveUpdateOperatorDetailsForm(LoanOperatorDetails loanOperatorDetails) {
		return this.loanOperatorDetailsRepository.save(loanOperatorDetails);
	}

	@Override
	public LoanOperatorDetails updateOperatorDetailsForm(LoanOperatorDetails loanOperatorDetails) {
		return this.loanOperatorDetailsRepository.save(loanOperatorDetails);
	}

	@Override
	public LoanOperatorDetails deleteOperatorDetails(LoanOperatorDetails loanOperatorDetails) {
		return this.loanOperatorDetailsRepository.save(loanOperatorDetails);
	}

}
