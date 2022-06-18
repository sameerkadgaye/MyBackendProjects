/**
 * 
 */
package com.practice.service.inf.admin.acOpenings.schedule;

import java.util.Date;
import java.util.List;

import com.practice.model.admin.acOpenings.schedule.LoanScheduleDetails;

/**
 * @author ashwini.shebe
 *
 */
public interface LoanScheduleDetailsService {
	public List<LoanScheduleDetails> getLoanScheduleDetails(Date transData);

}
