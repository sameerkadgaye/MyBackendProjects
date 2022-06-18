/**
 * 
 */
package com.practice.controller.admin.acOpenings.schedule;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.acOpenings.schedule.LoanScheduleDetails;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.schedule.LoanScheduleDetailsService;



/**
 * @author palash.kharwade
 *
 */

@RestController
@CrossOrigin
public class LoanScheduleDetailsController {

	@Autowired
	private LoanScheduleDetailsService loanScheduleDetailsService;
	
	@GetMapping("/loanSchedule/ReceiptDate/{recDate}")
	public ResponseEntity<RequestResponse> getReceiptTableDataByDate(@PathVariable("recDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date recDate) {
		
		//System.out.println("accTransaction recDate===>>> "+recDate);
		List<LoanScheduleDetails> loanScheduleDetails = this.loanScheduleDetailsService.getLoanScheduleDetails(recDate);
		System.out.println("accTransaction===>>> "+loanScheduleDetails);
		if (loanScheduleDetails == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					loanScheduleDetails);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, loanScheduleDetails);
		}
	} 
	
}
