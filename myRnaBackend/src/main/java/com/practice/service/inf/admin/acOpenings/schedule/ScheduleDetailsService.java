package com.practice.service.inf.admin.acOpenings.schedule;

import java.util.Date;
import java.util.List;

import com.practice.model.admin.acOpenings.schedule.ScheduleDetails;

/**
 * @author ashwini.shebe
 *
 */
public interface ScheduleDetailsService {
	
	public List<ScheduleDetails> getScheduleDetails(Date transData);

	public List<ScheduleDetails> getScheduleDetails(Long customerCode, Long scheduleNo, Date transData);

	public List<ScheduleDetails> getScheduleListForReschedule(Date transData);

	List<ScheduleDetails> getScheduleList(Date transData);

	public List<ScheduleDetails> getScheduleDetailsForRecoveryReceiptForm(Date transData);
	
	public List<ScheduleDetails> updateScheduleDetails(List<ScheduleDetails> scheduleDetailsData);

}
