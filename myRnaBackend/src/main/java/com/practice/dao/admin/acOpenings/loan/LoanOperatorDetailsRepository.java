/**
 * 
 */
package com.practice.dao.admin.acOpenings.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.loan.LoanOperatorDetails;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 31/01/2022
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Repository
public interface LoanOperatorDetailsRepository extends JpaRepository<LoanOperatorDetails, Long> {

}
