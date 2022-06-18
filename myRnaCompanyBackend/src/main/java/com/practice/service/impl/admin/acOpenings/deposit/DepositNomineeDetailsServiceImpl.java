/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.deposit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.deposit.DepositNomineeDetailsRepository;
import com.practice.model.admin.acOpenings.deposit.DepositNomineeDetails;
import com.practice.service.inf.admin.acOpenings.deposit.DepositNomineeDetailsService;

/**
 * @author SAMEER KADGAYE
 *
 */
@Service
public class DepositNomineeDetailsServiceImpl implements DepositNomineeDetailsService {

	@Autowired
	private DepositNomineeDetailsRepository depositNomineeDetailsRepository;

	@Override
	public DepositNomineeDetails saveDepositNomineeDetails(DepositNomineeDetails depositNomineeDetails) {
		return this.depositNomineeDetailsRepository.save(depositNomineeDetails);
	}

	@Override
	public List<DepositNomineeDetails> getDepositNomineeDetails() {
		return this.depositNomineeDetailsRepository.findAll();
	}

	@Override
	public DepositNomineeDetails getDepositNomineeDetailsById(Long despositNomineeDetailsId) {
		return this.depositNomineeDetailsRepository.findById(despositNomineeDetailsId).get();
	}

	@Override
	public void updateDepositNomineeDetails(DepositNomineeDetails depositNomineeDetails) {

	}

	@Override
	public DepositNomineeDetails deleteDepositNomineeDetailsStatusChange(Long despositNomineeDetailsId) {
		DepositNomineeDetails depositNomineeDetails = this.depositNomineeDetailsRepository
				.findById(despositNomineeDetailsId).get();
		depositNomineeDetails.setStatus(true);
		return this.depositNomineeDetailsRepository.save(depositNomineeDetails);
	}

}
