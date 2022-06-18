package com.practice.dao.admin.acOpenings.acTransaction;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.acTransaction.AccTransaction;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 02/12/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@Repository
public interface AccTransactionRepository extends JpaRepository<AccTransaction, Long>{
	
	public AccTransaction findById(long acTrnId);
	
	public List<AccTransaction> findByReceiptDate(Date receiptDate);
	
	public List<AccTransaction> findByStatusFalse();
	
	@Query("SELECT max(docNo) FROM AccTransaction") 
	public String getMaxDocNo();

	public List<AccTransaction> findByDocNoAndStatusFalse(@Param("docNo") String docNo);
	
	//select count(receipt_date) from rnas.tab_acc_transaction where tran_type ='Receipt' and receipt_date ='2021-12-24'; 
	@Query("select sum(amount) from AccTransaction at where at.tranType ='Receipt' and at.receiptDate=:receiptDate")
	public Long getTodaysReceiptCount(Date receiptDate);

	//select count(receipt_date) from rnas.tab_acc_transaction where tran_type ='Payment' and receipt_date ='2021-12-24'
	@Query("select sum(amount) from AccTransaction at where at.tranType ='Payment' and at.receiptDate=:receiptDate")
	public Long getTodaysPaymentCount(Date receiptDate);
}
