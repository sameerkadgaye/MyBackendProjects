/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.deposit;

import java.util.List;

import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;

/**
 * @author SAMEER KADGAYE
 *
 */
public interface DepositAccountService {

	public DepositAccount saveDepositAccount(DepositAccount depositAccount);

	public List<DepositAccount> updateDepositAccountList(List<DepositAccount> depositAccounts);

	public List<DepositAccount> getDepositAccount();

	public DepositAccount getDepositAccountById(Long depositAccountId);

	public void deleteDepositAccount(Long depositAccountId);

	public void updateDepositAccount(DepositAccount depositAccount);

	// get Customer Id Wise Deposite Accounts
	public List<DepositAccount> getCustomerIdWiseDepositAccount(Long customerMasterId);

	// get Customer Code Wise Deposite Accounts
	public List<DepositAccount> getCustomerCodeWiseDepositAccount(Long customerCode);

	public CustomerMaster getCustomerMasterByDepositAccountId(Long depositAccountId);

	public DepositAccount getDepositAccountByAccountNo(Long accountcNo);

	public Long getMaxAccountNo();

	public Long getMaxApplicationNo();

	public Long getCustomerMasterCodeByDepositAccountId(Long depositAccountId);

	public DepositAccount getDepositAccountByAccountNoAndCustomerCode(Long customerCode, Long accountNo);

	public List<DepositAccount> getCustomerNameWiseDepositAccount(String customerName);
}
