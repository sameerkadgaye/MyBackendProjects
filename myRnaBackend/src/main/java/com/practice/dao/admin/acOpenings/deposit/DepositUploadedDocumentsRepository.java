/**
 * 
 */
package com.practice.dao.admin.acOpenings.deposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.acOpenings.deposit.DepositUploadedDocuments;

/**
 * @author SAMEER KADGAYE
 *
 */
@Repository
public interface DepositUploadedDocumentsRepository extends JpaRepository<DepositUploadedDocuments, Long> {
	public List<DepositUploadedDocuments> findByDepositAccount(DepositAccount depositAccount);
}
