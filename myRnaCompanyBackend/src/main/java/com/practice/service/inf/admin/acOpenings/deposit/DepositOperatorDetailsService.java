/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.deposit;

import java.util.List;

import com.practice.model.admin.acOpenings.deposit.DepositOperatorDetails;

/**
 * @author SAMEER KADGAYE
 *
 */
public interface DepositOperatorDetailsService {
	
	public DepositOperatorDetails saveDepositOperatorDetail(DepositOperatorDetails depositOperatorDetail);
	
	public List<DepositOperatorDetails> saveDepositOperatorDetails(List<DepositOperatorDetails> depositOperatorDetails);

	public List<DepositOperatorDetails> getDepositOperatorDetails();

	public DepositOperatorDetails getDepositOperatorDetailsById(Long depositOperatorDetailsId);

	public void deleteDepositOperatorDetails(Long depositOperatorDetailsId);

	public void updateDepositOperatorDetails(DepositOperatorDetails depositAccount);
	
	// get Deposite Id Wise DepositOperatorDetails Accounts
	public List<DepositOperatorDetails> getDepositeAccountIdWiseDepositOperatorDetails(Long depositAccountId);
}
