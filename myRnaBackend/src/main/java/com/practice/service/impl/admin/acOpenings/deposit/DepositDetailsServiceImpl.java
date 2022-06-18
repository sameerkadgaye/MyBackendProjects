/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.deposit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.deposit.DepositDetailsRepository;
import com.practice.model.admin.acOpenings.deposit.DepositDetails;
import com.practice.service.inf.admin.acOpenings.deposit.DepositDetailsService;

/**
 * @author SAMEER KADGAYE
 *
 */
@Service
public class DepositDetailsServiceImpl implements DepositDetailsService{

	@Autowired
	private DepositDetailsRepository depositDetailsRepository;

	@Override
	public DepositDetails saveDepositDetails(DepositDetails depositDetails) {
		return this.depositDetailsRepository.save(depositDetails);
	}

	@Override
	public List<DepositDetails> getDepositDetails() {
		return this.depositDetailsRepository.findAll();
	}

	@Override
	public DepositDetails getDepositDetailsById(Long depositDetailsId) {
		return this.depositDetailsRepository.findById(depositDetailsId).get();
	}

	@Override
	public DepositDetails deleteDepositDetails(Long depositDetailsId) {
		return null;
	}

	@Override
	public void updateDepositDetails(DepositDetails depositDetails) {
		
	}

	@Override
	public Long getReceiptNo() {
		return this.depositDetailsRepository.getReceiptNo();
	}
}
