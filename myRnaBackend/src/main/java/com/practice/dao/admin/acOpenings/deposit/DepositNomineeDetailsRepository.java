/**
 * 
 */
package com.practice.dao.admin.acOpenings.deposit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.deposit.DepositNomineeDetails;

/**
 * @author SAMEER KADGAYE
 *
 */
@Repository
public interface DepositNomineeDetailsRepository extends JpaRepository<DepositNomineeDetails, Long>{

}
