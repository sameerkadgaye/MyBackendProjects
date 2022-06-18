/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.deposit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.deposit.DepositAccountRepository;
import com.practice.dao.admin.acOpenings.deposit.DepositEmiCalculatorRepository;
import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.acOpenings.deposit.DepositEmiCalculator;
import com.practice.service.inf.admin.acOpenings.deposit.DepositEmiCalculatorService;

/**
 * @author SAMEER KADGAYE
 *
 */
@Service
public class DepositEmiCalculatorServiceImpl implements DepositEmiCalculatorService {

	@Autowired
	private DepositEmiCalculatorRepository depositEmiCalculatorRepository;

	@Autowired
	private DepositAccountRepository depositAccountRepository;

	@Override
	public List<DepositEmiCalculator> getDepositEmiCalculatorsByDepositAccountNo(Long accountNo) {
		DepositAccount findByAccountNo = depositAccountRepository.findByAccountNo(accountNo);
		return this.depositEmiCalculatorRepository.findByDepositAccount(findByAccountNo);
	}

	// Sameer Work Starts======>>>

	@Override
	public DepositEmiCalculator saveDepositEmiCalculator(DepositEmiCalculator DepositEmiCalculator) {
		return this.depositEmiCalculatorRepository.save(DepositEmiCalculator);
	}

	@Override
	public List<DepositEmiCalculator> saveDepositEmiCalculators(List<DepositEmiCalculator> DepositEmiCalculators) {
		return this.depositEmiCalculatorRepository.saveAll(DepositEmiCalculators);
	}

	@Override
	public List<DepositEmiCalculator> getDepositEmiCalculators() {
		return this.depositEmiCalculatorRepository.findAll();
	}

	@Override
	public DepositEmiCalculator getDepositEmiCalculatorById(Long despositEmiCalculatorId) {
		return this.depositEmiCalculatorRepository.findById(despositEmiCalculatorId).get();
	}

	@Override
	public void deleteDepositEmiCalculator(Long despositEmiCalculatorId) {

	}

	@Override
	public void updateDepositEmiCalculator(DepositEmiCalculator DepositEmiCalculator) {
	}
	// Sameer Work Ends ======>>>
}
