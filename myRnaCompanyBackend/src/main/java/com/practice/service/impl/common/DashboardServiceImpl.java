package com.practice.service.impl.common;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.acTransaction.AccTransactionRepository;
import com.practice.dao.admin.acOpenings.deposit.DepositAccountRepository;
import com.practice.dao.admin.acOpenings.deposit.DepositDetailsRepository;
import com.practice.dao.admin.acOpenings.loan.LoanAccountRepository;
import com.practice.service.inf.common.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DepositAccountRepository depositAccountRepository;
	
	@Autowired
	private LoanAccountRepository loanAccountRepository;

	@Autowired
	private AccTransactionRepository accTransactionRepository;
	
	@Autowired 
	private DepositDetailsRepository depositDetailsRepository;
	
	@Override
	public Long getDepositAccountsCountOnToday() {
		Long count = depositAccountRepository.getDepositAccountsCountOnToday();
		return count;
	}

	@Override
	public Long getLoanAccountsCountOnToday() {
		// TODO Auto-generated method stub
		return loanAccountRepository.getLoanAccountsCountOnToday();
	}

	@Override
	public Long getTodaysReceiptCount(Date receiptDate) {
		// TODO Auto-generated method stub
		return this.accTransactionRepository.getTodaysReceiptCount(receiptDate);
	}

	@Override
	public Long getTodaysPaymentCount(Date receiptDate) {
		// TODO Auto-generated method stub
		return this.accTransactionRepository.getTodaysPaymentCount(receiptDate);
	}

//	@Override
//	public List<DepositDetails> getDepositeMonthWiseDetails() {
//		// TODO Auto-generated method stub List<Student> studsAll = this.studentRepository.findAll();
//		Object details=this.depositDetailsRepository.getDepositeMonthWiseDetails();
//		return details;
//	}
	
//	@Override
//	public List<?> getDepositeMonthWiseDetails() {
//		// TODO Auto-generated method stub List<Student> studsAll = this.studentRepository.findAll();
//		List<?> details=this.depositDetailsRepository.getDepositeMonthWiseDetails();
//		return details;
//	}

}
