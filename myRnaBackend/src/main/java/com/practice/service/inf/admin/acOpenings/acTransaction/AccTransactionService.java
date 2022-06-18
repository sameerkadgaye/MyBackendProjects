package com.practice.service.inf.admin.acOpenings.acTransaction;

import java.util.Date;
import java.util.List;

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
public interface AccTransactionService {
	public List<AccTransaction> saveAcTransactions(List<AccTransaction> accTranData);

	//public List<DocumentMaster> getDocumentMasterData();

	public List<AccTransaction> findAcTransactionsByStatus();

	public AccTransaction findAcTransactionsById(Long acTrnId);

	public List<AccTransaction> findAcTransactionsByDate(Date receiptDate);
	
	public void updateDocument(AccTransaction acTrans , long acTrnId);
	
	public String getMaxDocNo();
}
