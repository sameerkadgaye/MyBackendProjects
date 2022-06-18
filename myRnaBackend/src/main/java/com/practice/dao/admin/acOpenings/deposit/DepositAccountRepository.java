/**
 * 
 */
package com.practice.dao.admin.acOpenings.deposit;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;

/**
 * @author SAMEER KADGAYE
 *
 */
@Repository
public interface DepositAccountRepository extends JpaRepository<DepositAccount, Long> {

	@Query("select vc from DepositAccount vc where vc.transactionDate between ?1 and ?2")
	public List<DepositAccount> findByTransactionDateBetween(Date fromDate, Date toDate);
	
	public List<DepositAccount> findByStatusFalse();
	
	public List<DepositAccount> findByCustomerMaster(CustomerMaster customerMaster);

	public DepositAccount findByAccountNo(Long accountNo);
	// public List<DepositAccount> findByAccountcNo(Integer accountcNo);

	@Query("SELECT max(accountNo)+1 FROM DepositAccount")
	public Long getMaxAccountNo();

	@Query("SELECT max(applicationNo)+1 FROM DepositAccount")
	public Long getMaxApplicationNo();

	// For Deposit Details
	@Query("select da.customerMaster from DepositAccount da where da.depositAccountId=:depositAccountId")
	public CustomerMaster getCustomerMasterByDepositAccountId(Long depositAccountId);

	// No of Deposites on today select count(transaction_date) from
	// rnas.tab_deposit_account ';
	@Query("select count(transactionDate) from DepositAccount da")
	public Long getDepositAccountsCountOnToday();

//	@Query("select op.depositAccount.depositAccountId from DepositOperatorDetails op where op.depositOperatorDetailsId=:depositOperatorDetailsId")
//	public Long getDepositeAccountIdByDepositAccountId(Long depositOperatorDetailsId);
	@Query("select da.customerMaster.customerCode from DepositAccount da where da.depositAccountId=:depositAccountId")
	public Long getCustomerMasterCodeByDepositAccountId(Long depositAccountId);

	public DepositAccount findByCustomerCodeAndAccountNo(Long customerCode, Long accountNo);

	public List<DepositAccount> findByAccountName(String customerName);

}
