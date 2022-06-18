/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.loan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.loan.LoanAccountRepository;
import com.practice.model.admin.acOpenings.loan.LoanAccount;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;
import com.practice.service.inf.admin.acOpenings.loan.LoanAccountService;
import com.practice.service.inf.admin.masters.customerMaster.CustomerMasterService;

/**
 * @author palash.kharwade
 *
 */

@Service
public class LoanAccountServiceImpl implements LoanAccountService {

	@Autowired
	private LoanAccountRepository loanAccountRepository;
	
	@Autowired
	private CustomerMasterService customerMasterService;

	@Override
	public LoanAccount getLoanAccountById(Long loanAccountId) {
		// TODO Auto-generated method stub
		return this.loanAccountRepository.findById(loanAccountId).get();
	}

	@Override
	public List<LoanAccount> getAllLoanAccounts() {
		return this.loanAccountRepository.getAllLoanAccounts();
//		 return this.loanAccountRepository.findAll().stream().filter(loan -> loan.getStatus() == false).collect(Collectors.toList());
	}

	@Override
	public LoanAccount saveLoanAccount(LoanAccount loanAccount) {
		return this.loanAccountRepository.save(loanAccount);
	}

	@Override
	public List<LoanAccount> getCustomerCodeWiseLoanAccount(Long customerCode) {
		CustomerMaster customerMasterByCustomerCode = this.customerMasterService.findByCustomerCode(customerCode);
		System.out.println("Customer list by customer code : "+customerMasterByCustomerCode);
		List<LoanAccount> loanaccountlist = this.loanAccountRepository.findByCustomerCode(customerCode);
//		return this.loanAccountRepository.findByCustomerMaster(customerMasterByCustomerCode);
		return loanaccountlist;
	}

	@Override
	public LoanAccount getLoanAccountByAccountNoAndCustomerCode(Long customerCode, Long accountNo) {
		// TODO Auto-generated method stub
		return this.loanAccountRepository.findByCustomerCodeAndAccountNo(customerCode, accountNo);
	}

	@Override
	public List<LoanAccount> getCustomerNameWiseLoanAccount(String customerName) {
		// TODO Auto-generated method stub
		return this.loanAccountRepository.findByAccountName(customerName);
	}

}
