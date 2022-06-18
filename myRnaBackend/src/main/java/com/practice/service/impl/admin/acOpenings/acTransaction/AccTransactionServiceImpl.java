package com.practice.service.impl.admin.acOpenings.acTransaction;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.acTransaction.AccTransactionRepository;
import com.practice.model.admin.acOpenings.acTransaction.AccTransaction;
import com.practice.service.inf.admin.acOpenings.acTransaction.AccTransactionService;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 16/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Service
public class AccTransactionServiceImpl implements AccTransactionService {
	@Autowired
	private AccTransactionRepository accTransactionRepository;

	@Override
	public List<AccTransaction> saveAcTransactions(List<AccTransaction> accTranData) {
		List<AccTransaction> accTrns = this.accTransactionRepository.saveAll(accTranData); 
		return accTrns;
	}

	@Override
	public List<AccTransaction> findAcTransactionsByStatus() {

		return this.accTransactionRepository.findByStatusFalse();
	}

	@Override
	public AccTransaction findAcTransactionsById(Long acTrnId) {

		return this.accTransactionRepository.findById(acTrnId).get();
	}

	@Override
	public void updateDocument(AccTransaction acTrans, long acTrnId) {

		acTrans.setAcTrnId(acTrnId);
		this.accTransactionRepository.save(acTrans);

	}

	@Override
	public String getMaxDocNo() {

		String num = null;
		String generatedDocNo = null;

		try {
			num = this.accTransactionRepository.getMaxDocNo();
			if (num == null) {
				// System.out.println("glType in service=====>>>>"+glType);
				generatedDocNo = "Rec0000";
			} else {
				generatedDocNo = num;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("genetatedCode in service=====>>>>"+genetatedCode);
		return generatedDocNo;
	}

	@Override
	public List<AccTransaction> findAcTransactionsByDate(Date receiptDate) {
		
		return this.accTransactionRepository.findByReceiptDate(receiptDate);
		
	}

}
