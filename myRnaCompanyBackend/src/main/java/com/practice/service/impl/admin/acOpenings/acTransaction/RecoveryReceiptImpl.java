package com.practice.service.impl.admin.acOpenings.acTransaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.acTransaction.RecoveryReceiptRepository;
import com.practice.model.admin.acOpenings.acTransaction.RecoveryReceipt;
import com.practice.service.inf.admin.acOpenings.acTransaction.RecoveryReceiptService;

@Service
public class RecoveryReceiptImpl    implements RecoveryReceiptService {

	
	@Autowired
	private RecoveryReceiptRepository recoveryReceiptRepository;

	@Override
	public RecoveryReceipt findAcTransactionsById(Long acTrnId) {
		
		return this.recoveryReceiptRepository.findById(acTrnId).get();
	}

	@Override
	public List<RecoveryReceipt> saveAcTransactions(List<RecoveryReceipt> accTransListForSave) {
	    
		List<RecoveryReceipt> accTrns = this.recoveryReceiptRepository.saveAll(accTransListForSave);
		return accTrns;
	}

	@Override
	public String getMaxDocNo() {
		String num = null;
		String generatedDocNo = null;

		try {
			num = this.recoveryReceiptRepository.getMaxDocNo();
			System.out.println("num in Recovery Service"+num);
			if (num.equals("null")) {
				generatedDocNo = "Rec0000";
			} else {
				generatedDocNo = num;
				System.out.println("Inside  generatedDocNo Null service=====>>>>"+generatedDocNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 System.out.println("genetatedCode in service=====>>>>"+generatedDocNo);
		return generatedDocNo;
	}

	
	
	
}
