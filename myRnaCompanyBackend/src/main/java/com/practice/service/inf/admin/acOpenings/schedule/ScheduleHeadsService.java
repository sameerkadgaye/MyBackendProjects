/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.schedule;

import java.util.List;

import com.practice.model.admin.acOpenings.schedule.ScheduleHeads;

/**
 * @author ashwini.shebe
 *
 */
public interface ScheduleHeadsService {
	//public List<ScheduleHeads> getScheduleHeads(Date recDate);

	public ScheduleHeads addDepositSchedule(ScheduleHeads scheduleHead);

	public List<ScheduleHeads> getScheduleData(Long customerCode);

	public List<ScheduleHeads> getScheduleHeadsData(Long transData);

	public List<ScheduleHeads> getScheduleListByCustomerCodeAccNo(Long customerCode, Long accountNo, String newScheduleStatus, String scheduleType);

	public ScheduleHeads updateDepositSchedule(Long transId);

	public List<ScheduleHeads> getAvailableScheduleListByCustomerCodeAccNo(Long customerCode, Long accountNo);

	public List<ScheduleHeads> getAvailableScheduleListByCustomerCodeAccNo(Long customerCode, Long accountNo,
			String scheduleType);

//	public List<ScheduleHeads> getScheduleNoAndScheduleDateData(Long scheduleId, Date transId);

}
