/**
 * 
 */
package com.practice.dao.admin.acOpenings.deposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.acOpenings.deposit.DepositEmiCalculator;

/**
 * @author SAMEER KADGAYE
 *
 */
@Repository
public interface DepositEmiCalculatorRepository extends JpaRepository<DepositEmiCalculator, Long> {
	public List<DepositEmiCalculator> findByDepositAccount(DepositAccount depositAccount);

}
