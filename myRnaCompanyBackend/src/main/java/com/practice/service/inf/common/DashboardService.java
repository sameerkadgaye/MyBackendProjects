package com.practice.service.inf.common;

import java.util.Date;

public interface DashboardService {
	public Long getDepositAccountsCountOnToday();
	
	public Long getLoanAccountsCountOnToday();
	
	public Long getTodaysReceiptCount(Date receiptDate);
	
	public Long getTodaysPaymentCount(Date receiptDate);
	
	//public List<DepositDetails> getDepositeMonthWiseDetails();
	//public List<?> getDepositeMonthWiseDetails();

}
