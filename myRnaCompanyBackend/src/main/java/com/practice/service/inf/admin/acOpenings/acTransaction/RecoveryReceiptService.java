package com.practice.service.inf.admin.acOpenings.acTransaction;

import java.util.List;

import com.practice.model.admin.acOpenings.acTransaction.RecoveryReceipt;

public interface RecoveryReceiptService {

	RecoveryReceipt findAcTransactionsById(Long acTrnId);

	List<RecoveryReceipt> saveAcTransactions(List<RecoveryReceipt> accTransListForSave);

	String getMaxDocNo();

}
