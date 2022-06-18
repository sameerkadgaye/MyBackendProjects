package com.practice.dao.admin.acOpenings.schedule;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.admin.acOpenings.schedule.ScheduleHeads;

/**
 * @author Palash Kharwade
 *
 */
@Repository
public interface ScheduleHeadsRepository extends JpaRepository<ScheduleHeads, Long> {
	

	//@Query("select vc from ScheduleHeads vc join vc.scheduleDetails vf where vf.transData = ?1 group by vc")
	//@Query("select tsd from ScheduleDetails tsd join tsd.scheduleHeads tsh on tsh.transId = tsd.scheduleHeads where tsd.transData =?1")
	//public List<ScheduleHeads> findByTransData(Date transData);
	
	@Query("select vc from ScheduleHeads vc join vc.scheduleDetails vf where vf.scheduleDetailsId = ?1 group by vc")
	public List<ScheduleHeads> findByScheduleDetailsScheduleDetailsId(Long scheduleDetailsId);

	public List<ScheduleHeads> findByCustomerCode(Long accountNo);

	public ScheduleHeads findByScheduleId(Long scheduleStatusNo);
	
	public List<ScheduleHeads> findByCustomerCodeAndAccountNoAndNewScheduleStatus(Long customerCode, Long accountNo, String newScheduleStatus);

	public List<ScheduleHeads> findByCustomerCodeAndAccountNo(Long customerCode, Long accountNo);
	
//	@Query("select vc from ScheduleHeads vc join vc.scheduleDetails vf on tsh.transId = tsd.scheduleHeads where vf.transData = ?1 and vc.scheduleId = ?2 group by vc")
//	public List<ScheduleHeads> findByTransData(Date transData);	

	@Query("select vc from ScheduleHeads vc where vc.fromDate between ?1 and ?2 and vc.newScheduleStatus='Active'")
	public List<ScheduleHeads> findByFromDateBetween(Date fromDate, Date toDate);
	
	public List<ScheduleHeads> findByCustomerCodeAndAccountNoAndNewScheduleStatusAndScheduleType(Long customerCode, Long accountNo,
			String newScheduleStatus, String scheduleType);

	public List<ScheduleHeads> findByCustomerCodeAndAccountNoAndScheduleType(Long customerCode, Long accountNo,
			String scheduleType);
	
}
