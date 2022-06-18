package com.practice.dao.admin.acOpenings.acTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.acTransaction.RecoveryReceipt;


@Repository
public interface RecoveryReceiptRepository extends  JpaRepository<RecoveryReceipt, Long>{

	
	@Query("SELECT max(docNo) FROM RecoveryReceipt") 
	String getMaxDocNo();
	
	
	
	
}
