/**
 * 
 */
package com.practice.dao.admin.acOpenings.loan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.loan.LoanGuarantorDetails;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 03/02/2022
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@Repository
public interface LoanGuarantorDetailsRepository extends JpaRepository<LoanGuarantorDetails, Long> {

//	Method To Get All Loan Guarantor Details Where Status is false
	@Query("from LoanGuarantorDetails as p where p.status = false") // HQL Script
	List<LoanGuarantorDetails> getAllLoanGuarantorDetails();

}
