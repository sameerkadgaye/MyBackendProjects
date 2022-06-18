/**
 * 
 */
package com.practice.service.impl.admin.acOpenings.schedule;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.acOpenings.schedule.LoanScheduleDetailsRepository;
import com.practice.model.admin.acOpenings.schedule.LoanScheduleDetails;
import com.practice.service.inf.admin.acOpenings.schedule.LoanScheduleDetailsService;

/**
 * @author ashwini.shebe
 *
 */
@Service
public class LoanScheduleDetailsImpl implements LoanScheduleDetailsService{
	
	@Autowired
	private LoanScheduleDetailsRepository loanScheduleDetailsRepository;

	@Override
	public List<LoanScheduleDetails> getLoanScheduleDetails(Date transData) {
		return this.loanScheduleDetailsRepository.findByTransData(transData).stream().filter(sd -> sd.getBalance() != null).collect(Collectors.toList());
	}

}


