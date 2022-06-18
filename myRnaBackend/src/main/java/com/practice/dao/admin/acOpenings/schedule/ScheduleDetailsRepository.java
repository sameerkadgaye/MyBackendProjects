package com.practice.dao.admin.acOpenings.schedule;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.schedule.ScheduleDetails;

/**
 * @author ashwini.shebe
 *
 */

@Repository
public interface ScheduleDetailsRepository extends JpaRepository<ScheduleDetails, Long> {
	// @Query("select sd from ScheduleDetails sd join sd.scheduleHeads sh where
	// sd.transData =?1 and sh.newScheduleStatus = 'Active'")
	@Query("select tsd From ScheduleDetails tsd JOIN tsd.scheduleHeads tsh where tsd.transData <=?1 and tsh.newScheduleStatus ='Active' and tsd.receiptApproveFlag = 'Unpaid'")
	public List<ScheduleDetails> findByTransData(Date transData);

	public List<ScheduleDetails> findByCustomerCodeAndScheduleNoAndTransData(Long customerCode, Long scheduleNo,
			Date transData);

	public List<ScheduleDetails> findByTransDataGreaterThanEqual(Date transDate);

	public List<ScheduleDetails> findByTransDataLessThanEqual(Date transDate);

	// @Query("select tsd from ScheduleDetails tsd where tsd.customerCode =?2 and
	// tsd.accountNo =?3 and tsd.transData =?1")
	@Query("select tsd from ScheduleDetails tsd join tsd.scheduleHeads sh where tsd.customerCode =?2 and tsd.accountNo =?3  and tsd.transData =?1 and sh.newScheduleStatus = 'Active'")
	public List<ScheduleDetails> findByTransDataForUpdate(Date transData, Long customerCode, Long accountNo);

	public ScheduleDetails findByScheduleDetailsId(Long scheduleId);

}
