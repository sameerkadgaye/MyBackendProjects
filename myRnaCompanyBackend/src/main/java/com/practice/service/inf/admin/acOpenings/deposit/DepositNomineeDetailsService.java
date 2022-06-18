/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.deposit;

import java.util.List;

import com.practice.model.admin.acOpenings.deposit.DepositNomineeDetails;

/**
 * @author SAMEER KADGAYE
 *
 */
public interface DepositNomineeDetailsService {
	public DepositNomineeDetails saveDepositNomineeDetails(DepositNomineeDetails depositNomineeDetails);

	public List<DepositNomineeDetails> getDepositNomineeDetails();

	public DepositNomineeDetails getDepositNomineeDetailsById(Long despositNomineeDetailsId);

	public DepositNomineeDetails deleteDepositNomineeDetailsStatusChange(Long despositNomineeDetailsId);

	public void updateDepositNomineeDetails(DepositNomineeDetails depositNomineeDetails);

}
