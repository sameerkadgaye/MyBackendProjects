package com.practice.service.impl.admin.acOpenings.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.schedule.ScheduleHeadsRepository;
import com.practice.model.admin.acOpenings.schedule.ScheduleHeads;
import com.practice.service.inf.admin.acOpenings.schedule.ScheduleHeadsService;

/**
 * @author ashwini.shebe
 *
 */

@Service
public class ScheduleHeadsServiceImpl implements ScheduleHeadsService{
	
	@Autowired
	private ScheduleHeadsRepository scheduleHeadsRepository;

//	@Override
//	public List<ScheduleHeads> getScheduleHeads(Date recDate) {
//		return this.scheduleHeadsRepository.findByTransData(recDate);
//	}

	@Override
	public ScheduleHeads addDepositSchedule(ScheduleHeads scheduleHead) {
		
//		Long scheduleId = scheduleHead.getScheduleId();
//		
//		if(scheduleId > 1) {
//			Long scheduleStatusNo = 1L;
//			scheduleHeadsRepository.findByScheduleId(scheduleStatusNo);
//		}
		
		return scheduleHeadsRepository.save(scheduleHead);
	}

	@Override
	public List<ScheduleHeads> getScheduleData(Long customerCode) {
		// TODO Auto-generated method stub
		return scheduleHeadsRepository.findByCustomerCode(customerCode);
	}

	@Override
	public List<ScheduleHeads> getScheduleHeadsData(Long transData) {
		// TODO Auto-generated method stub
		return scheduleHeadsRepository.findByScheduleDetailsScheduleDetailsId(transData);
	}

	@Override
	public List<ScheduleHeads> getScheduleListByCustomerCodeAccNo(Long customerCode, Long accountNo, String newScheduleStatus, String scheduleType) {
		// TODO Auto-generated method stub
		return scheduleHeadsRepository.findByCustomerCodeAndAccountNoAndNewScheduleStatusAndScheduleType(customerCode, accountNo, newScheduleStatus, scheduleType);
	}

	@Override
	public ScheduleHeads updateDepositSchedule(Long transId) {
		ScheduleHeads scheduleHead = null;
		scheduleHead = scheduleHeadsRepository.findById(transId).get();
		scheduleHead.setNewScheduleStatus("Deactive");
		
		return scheduleHeadsRepository.save(scheduleHead);
	}

	@Override
	public List<ScheduleHeads> getAvailableScheduleListByCustomerCodeAccNo(Long customerCode, Long accountNo) {
		// TODO Auto-generated method stub
		return scheduleHeadsRepository.findByCustomerCodeAndAccountNo(customerCode, accountNo);
	}

	@Override
	public List<ScheduleHeads> getAvailableScheduleListByCustomerCodeAccNo(Long customerCode, Long accountNo,
			String scheduleType) {
		// TODO Auto-generated method stub
		return scheduleHeadsRepository.findByCustomerCodeAndAccountNoAndScheduleType(customerCode, accountNo,scheduleType);
	}

//	@Override
//	public List<ScheduleHeads> getScheduleNoAndScheduleDateData(Long scheduleId, Date transId) {
//		// TODO Auto-generated method stub
//		return scheduleHeadsRepository.findByTransData(transData);
//	}

}
