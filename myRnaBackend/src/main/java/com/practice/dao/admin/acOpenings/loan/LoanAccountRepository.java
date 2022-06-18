package com.practice.dao.admin.acOpenings.loan;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.loan.LoanAccount;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;

@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccount, Long> {

	
	@Query("select la from LoanAccount la where la.transactionDate between ?1 and ?2")
	List<LoanAccount> findByTransactionDateBetween(Date fromDate, Date toDate);

	// No of Loan on today select count(transaction_date) from rnas.tab_loan_account
	@Query("select count(transactionDate) from LoanAccount la")
	public Long getLoanAccountsCountOnToday();

	@Query("from LoanAccount as p where p.status = false order by accountNo DESC") // HQL Script
	public List<LoanAccount> getAllLoanAccounts();

	@Query("SELECT max(accountNo)+1 FROM LoanAccount")
	public Long getMaxAccountNo();

	@Query("SELECT max(applicationNo)+1 FROM LoanAccount")
	public Long getMaxApplicationNo();

	List<LoanAccount> findByCustomerMaster(CustomerMaster customerMasterByCustomerCode);

	List<LoanAccount> findByCustomerCode(Long customerCode);

	LoanAccount findByCustomerCodeAndAccountNo(Long customerCode, Long accountNo);

	List<LoanAccount> findByAccountName(String customerName);

}
