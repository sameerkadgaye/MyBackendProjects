/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.deposit;

import java.util.List;

import com.practice.model.admin.acOpenings.deposit.DepositEmiCalculator;

/**
 * @author SAMEER KADGAYE
 *
 */
public interface DepositEmiCalculatorService {
	public List<DepositEmiCalculator> getDepositEmiCalculatorsByDepositAccountNo(Long accountNo);

	// SAMEER WORK Starts
	public DepositEmiCalculator saveDepositEmiCalculator(DepositEmiCalculator DepositEmiCalculator);

	public List<DepositEmiCalculator> saveDepositEmiCalculators(List<DepositEmiCalculator> DepositEmiCalculators);

	public List<DepositEmiCalculator> getDepositEmiCalculators();

	public DepositEmiCalculator getDepositEmiCalculatorById(Long despositEmiCalculatorId);

	public void deleteDepositEmiCalculator(Long despositEmiCalculatorId);

	public void updateDepositEmiCalculator(DepositEmiCalculator DepositEmiCalculator);
	// SAMEER WORK Starts
}
