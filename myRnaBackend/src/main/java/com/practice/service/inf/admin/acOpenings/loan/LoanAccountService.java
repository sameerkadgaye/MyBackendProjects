/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.loan;

import java.util.List;

import com.practice.model.admin.acOpenings.loan.LoanAccount;

/**
 * @author palash.kharwade
 *
 */
public interface LoanAccountService {

	public LoanAccount getLoanAccountById(Long loanAccountId);

	public List<LoanAccount> getAllLoanAccounts();

	public LoanAccount saveLoanAccount(LoanAccount loanAccount);

	public List<LoanAccount> getCustomerCodeWiseLoanAccount(Long customerCode);

	public LoanAccount getLoanAccountByAccountNoAndCustomerCode(Long customerCode, Long accountNo);

	public List<LoanAccount> getCustomerNameWiseLoanAccount(String customerName);

}
