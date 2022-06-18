/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.deposit;

import java.util.List;

import com.practice.model.admin.acOpenings.deposit.DepositDetails;

/**
 * @author SAMEER KADGAYE
 *
 */
public interface DepositDetailsService {

	public DepositDetails saveDepositDetails(DepositDetails depositDetails);

	//public List<DepositDetails> saveDepositDetails(List<DepositDetails> DepositDetails);

	public List<DepositDetails> getDepositDetails();

	public DepositDetails getDepositDetailsById(Long depositDetailsId);

	public DepositDetails deleteDepositDetails(Long depositDetailsId);

	public void updateDepositDetails(DepositDetails depositDetails);

	public Long getReceiptNo();

}
