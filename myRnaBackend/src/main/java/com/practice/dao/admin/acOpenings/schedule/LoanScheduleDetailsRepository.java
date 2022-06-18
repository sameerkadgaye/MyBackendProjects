/**
 * 
 */
package com.practice.dao.admin.acOpenings.schedule;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.schedule.LoanScheduleDetails;

/**
 * @author palash.kharwade
 *
 */

@Repository
public interface LoanScheduleDetailsRepository extends JpaRepository<LoanScheduleDetails, Long> {
	@Query("select tsd From LoanScheduleDetails tsd JOIN tsd.loanScheduleHeads tsh where tsd.transData <=?1 and tsh.newScheduleStatus ='Active' and tsd.receiptApproveFlag = 'Unpaid'")
	public List<LoanScheduleDetails> findByTransData(Date transData);

}
