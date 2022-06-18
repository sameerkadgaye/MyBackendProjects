package com.practice.service.impl.admin.acOpenings.schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.schedule.ScheduleDetailsRepository;
import com.practice.model.admin.acOpenings.schedule.ScheduleDetails;
import com.practice.service.inf.admin.acOpenings.schedule.ScheduleDetailsService;

/**
 * @author ashwini.shebe
 *
 */
@Service
public class ScheduleDetailsSeviceImpl implements ScheduleDetailsService {
	@Autowired
	private ScheduleDetailsRepository scheduleDetailsRepository;

	@Override
	public List<ScheduleDetails> getScheduleDetails(Date transData) {
		return this.scheduleDetailsRepository.findByTransData(transData).stream().filter(sd -> sd.getBalance() != null)
				.collect(Collectors.toList());
	}

	@Override
	public List<ScheduleDetails> getScheduleDetailsForRecoveryReceiptForm(Date transData) {

		return this.scheduleDetailsRepository.findByTransData(transData);
	}

	@Override
	public List<ScheduleDetails> getScheduleDetails(Long customerCode, Long scheduleNo, Date transData) {
		// TODO Auto-generated method stub
		return scheduleDetailsRepository.findByCustomerCodeAndScheduleNoAndTransData(customerCode, scheduleNo,
				transData);
	}

	@Override
	public List<ScheduleDetails> getScheduleListForReschedule(Date transData) {
		// TODO Auto-generated method stub
		return scheduleDetailsRepository.findByTransDataGreaterThanEqual(transData);
	}

	@Override
	public List<ScheduleDetails> getScheduleList(Date transData) {
		// TODO Auto-generated method stub
		return scheduleDetailsRepository.findByTransDataLessThanEqual(transData);
	}

	@Override
	public List<ScheduleDetails> updateScheduleDetails(List<ScheduleDetails> scheduleDetailsData) {
//		System.out.println("scheduleDetailsData===>>>" + scheduleDetailsData);
		// System.out.println("scheduleDetailsData===>>>"+scheduleDetailsData.get(1).getAccountNo());
		Long accountNo = 0L;
		Long customerCode = 0L;
		Double balance = 0.00;
		List<ScheduleDetails> scheduleDetails = null;
		List<ScheduleDetails> finalScheduleDetails = new ArrayList<>();
		Date transData = new Date();
		Long scheduleId = 0L;
		for (int i = 0; i < scheduleDetailsData.size(); i++) {
			accountNo = scheduleDetailsData.get(i).getAccountNo();
//			System.out.println("scheduleDetailsData===>>>" + scheduleDetailsData);
			customerCode = scheduleDetailsData.get(i).getCustomerCode();
			balance = scheduleDetailsData.get(i).getBalance();
			transData = scheduleDetailsData.get(i).getTransData();
//			System.out.println(" customerCode===>>>" + customerCode);
//			System.out.println(" balance===>>>" + balance);
//			System.out.println(" transData===>>>" + transData);
			scheduleDetails = this.scheduleDetailsRepository.findByTransDataForUpdate(transData, customerCode,
					accountNo);
//			System.out.println("scheduleDetails===>>>" + scheduleDetails);
//			System.out.println("scheduleDetails size ===>>>" + scheduleDetails.size());
			for(int j=0; j<scheduleDetails.size(); j++) {
				scheduleId = scheduleDetails.get(j).getScheduleDetailsId();
//				System.out.println("scheduleId==========>>>"+scheduleId);
				ScheduleDetails schedule = this.scheduleDetailsRepository.findByScheduleDetailsId(scheduleId);
//				System.out.println("schedule===>>>"+schedule);
				schedule.setReceiptApproveFlag("Paid");
				ScheduleDetails save = this.scheduleDetailsRepository.save(schedule);
//				System.out.println("schedule save===>>>"+save);
				finalScheduleDetails.add(save);
			}
		}
		//System.out.println("schedule save===>>>"+finalScheduleDetails);
		return finalScheduleDetails;
	}

}
