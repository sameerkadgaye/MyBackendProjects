/**
 * 
 */
package com.practice.dao.admin.acOpenings.deposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.acOpenings.deposit.DepositOperatorDetails;

/**
 * @author SAMEER KADGAYE
 *
 */
@Repository
public interface DepositOperatorDetailsRepository extends JpaRepository<DepositOperatorDetails, Long> {
	public List<DepositOperatorDetails> findByDepositAccount(DepositAccount depositAccount);
	
	@Query("select op.depositAccount.depositAccountId from DepositOperatorDetails op where op.depositOperatorDetailsId=:depositOperatorDetailsId")
	public Long getDepositeAccountIdByDepositAccountId(Long depositOperatorDetailsId);
}
	