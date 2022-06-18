package com.practice.model.common;
/**
 * @author dolly.raut
 *
 */
public interface LoanDepositeDetails {
	String getCustomerCode();
	String getScheduleType();
	String getAccountNo();
	Long getPrincipalAmount();
	Long getPrincipalRepay();
	Long getRecoveryAmount();
	String getCustomerName();
	String getInterestAmt();
	Long getTransRecPay();
}
