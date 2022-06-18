/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.deposit;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.deposit.DepositAccountRepository;
import com.practice.dao.admin.acOpenings.deposit.DepositOperatorDetailsRepository;
import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.acOpenings.deposit.DepositOperatorDetails;
import com.practice.service.inf.admin.acOpenings.deposit.DepositOperatorDetailsService;

/**
 * @author SAMEER KADGAYE
 *
 */
@Service
public class DepositOperatorDetailsServiceImpl implements DepositOperatorDetailsService{

	@Autowired
	private DepositOperatorDetailsRepository depositOperatorDetailsRepository;
	
	@Autowired
	private DepositAccountRepository depositAccountRepository;

	@Override
	public DepositOperatorDetails saveDepositOperatorDetail(DepositOperatorDetails depositOperatorDetail) {
		return this.depositOperatorDetailsRepository.save(depositOperatorDetail);
	}
	
	@Override
	public List<DepositOperatorDetails> saveDepositOperatorDetails(List<DepositOperatorDetails> depositOperatorDetails) {
		return this.depositOperatorDetailsRepository.saveAll(depositOperatorDetails);
	}

	@Override
	public List<DepositOperatorDetails> getDepositOperatorDetails() {
		return this.depositOperatorDetailsRepository.findAll();
	}

	@Override
	public DepositOperatorDetails getDepositOperatorDetailsById(Long depositOperatorDetailsId) {
		return this.depositOperatorDetailsRepository.findById(depositOperatorDetailsId).get();
	}

	@Override
	public void deleteDepositOperatorDetails(Long depositOperatorDetailsId) {
	}

	@Override
	public void updateDepositOperatorDetails(DepositOperatorDetails depositAccount) {
		
	}

	@Override
	public List<DepositOperatorDetails> getDepositeAccountIdWiseDepositOperatorDetails(Long depositAccountId) {
		DepositAccount depositAccount = this.depositAccountRepository.findById(depositAccountId).get();
		return depositAccount.getDepositOperatorDetailsList().stream().filter(opD -> opD.getStatus() == false).collect(Collectors.toList());
	}

}
