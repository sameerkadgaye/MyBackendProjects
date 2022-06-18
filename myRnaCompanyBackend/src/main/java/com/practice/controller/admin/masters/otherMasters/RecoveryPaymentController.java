/**
 * 
 */
package com.practice.controller.admin.masters.otherMasters;

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
import com.practice.dao.admin.acOpenings.schedule.ScheduleHeadsRepository;
import com.practice.model.admin.acOpenings.schedule.ScheduleHeads;
import com.practice.model.common.RequestResponse;

/**
 * @author dolly.raut
 *
 */

@RestController
@CrossOrigin
public class RecoveryPaymentController {

	@Autowired
	private ScheduleHeadsRepository scheduleHeadsRepository;
	
	
	@GetMapping("/listOfRecoveryPayments/{fromDate}/{toDate}")
	public ResponseEntity<RequestResponse> getlistOfRecoveryPaymentsBetDates(@PathVariable("fromDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDate, 
			@PathVariable("toDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date toDate) {
		
		System.out.println("From Date Are : "+fromDate);
		System.out.println("to Date Are : "+toDate);
		
		List<ScheduleHeads> listOfRecoveryPayment = this.scheduleHeadsRepository.findByFromDateBetween(fromDate, toDate);
		if (listOfRecoveryPayment == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,listOfRecoveryPayment);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,listOfRecoveryPayment);
	}
}
