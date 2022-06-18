/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.loan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.loan.LoanGuarantorDetailsRepository;
import com.practice.model.admin.acOpenings.loan.LoanGuarantorDetails;
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

@Service
public class LoanGuarantorDetailsServiceImpl implements LoanGuarantorDetailsService {

	@Autowired
	private LoanGuarantorDetailsRepository loanGuarantorDetailsRepository;

//	@Autowired
//	private LoanGuarantorDetailsService loanGuarantorDetailsService;

	@Override
	public List<LoanGuarantorDetails> getAllLoanGuarantorDetails() {
		return this.loanGuarantorDetailsRepository.getAllLoanGuarantorDetails();
	}

	@Override
	public LoanGuarantorDetails getLoanGuarantorDetailsById(Long loanGuarantorDetailsId) {
		return this.loanGuarantorDetailsRepository.findById(loanGuarantorDetailsId).get();
	}

	@Override
	public LoanGuarantorDetails saveUpdateLoanGuarantorDetailsForm(LoanGuarantorDetails loanGuarantorDetails) {
		return this.loanGuarantorDetailsRepository.save(loanGuarantorDetails);
	}

	@Override
	public LoanGuarantorDetails updateLoanGuarantorDetailsForm(LoanGuarantorDetails loanGuarantorDetails) {
		return this.loanGuarantorDetailsRepository.save(loanGuarantorDetails);
	}

	@Override
	public LoanGuarantorDetails deleteLoanGuarantorDetails(LoanGuarantorDetails loanGuarantorDetails) {
		return this.loanGuarantorDetailsRepository.save(loanGuarantorDetails);
	}

}
