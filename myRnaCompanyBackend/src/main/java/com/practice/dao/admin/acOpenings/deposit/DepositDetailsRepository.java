/**
 * 
 */
package com.practice.dao.admin.acOpenings.deposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.deposit.DepositDetails;
import com.practice.model.common.LoanDepositeDetails;
import com.practice.model.common.LoanDepositeListData;
import com.practice.model.common.PieChartLoanDeposit;

/**
 * @author SAMEER KADGAYE
 *
 */
@Repository
public interface DepositDetailsRepository extends JpaRepository<DepositDetails, Long> {

	@Query("SELECT max(receiptNo)+1 FROM DepositDetails")
	public Long getReceiptNo();

	// Find DepositDetails by Deposit Account.
	// public DepositDetails findByDepositAccount(DepositAccount depositAccount);

	// @Query("select depositDate,SUM(depositAmount)from DepositDetails group by
	// depositDate order by depositDate")
	// @Query("select date_trunc( 'month', depositDate )as month ,SUM(depositAmount)
	// as AMOUNT from DepositDetails group by month order by month ")

	String q = "select months, seq AS seq, SUM(loan_amount) AS loanAmount, SUM(deposit_amount) AS depositAmount from (\r\n"
			+ "select TO_CHAR(a.loan_date,'MON/YY') AS months, a.loan_amount AS loan_amount, 0 deposit_amount, TO_CHAR(a.loan_date,'MM') AS seq from rnas.tab_loan_details a\r\n"
			+ "union \r\n"
			+ "select TO_CHAR(v.deposit_date,'MON/YY') AS months, 0 loan_amount, (v.deposit_amount) AS deposit_amount, TO_CHAR(v.deposit_date,'MM') AS seq from rnas.tab_deposit_details v )B\r\n"
			+ "group by months, seq\r\n" + "order by seq";

//	@Query(value=q)
	@Query(value = q, nativeQuery = true)
	public List<LoanDepositeListData> getDepositMonthWiseDetails();

	// @Query("select new map(sum(depositAmount) as cnt) from DepositDetails v ")
	String pq = "select SUM(deposit_amount) AS value, 'Deposit' as label, 'red' as color  from rnas.tab_deposit_details \r\n"
			+ "	UNION\r\n"
			+ "	select SUM(loan_amount) AS value, 'Loan' as label, 'blue' as color  from rnas.tab_loan_details";

	@Query(value = pq, nativeQuery = true)
	public List<PieChartLoanDeposit> getPieChartForLoanDeposit();

	String dp = "select sd.customer_code as customerCode, rr.customer_name as customerName, sd.schedule_type as scheduleType, sd.account_no  as accountNo, \r\n"
			+ "sd.principal_amount as principalAmount, sd.principal_repay as principalRepay, rr.recovery_amount as recoveryAmount, sd.interest_amt as interestAmt,\r\n"
			+ "act.amount as transRecPay\r\n" + "from rnas.tab_recovery_receipt rr inner join\r\n"
			+ " rnas.tab_schedule_details sd on rr.customer_code = sd.customer_code inner join \r\n"
			+ " rnas.tab_acc_transaction act on rr.customer_code = act.customer_code\r\n"
			+ "	order by sd.schedule_type";

	@Query(value = dp, nativeQuery = true)
	public List<LoanDepositeDetails> getDetailsOfLoanDeposit();

}
