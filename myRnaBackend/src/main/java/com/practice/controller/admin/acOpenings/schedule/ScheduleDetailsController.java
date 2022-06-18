package com.practice.controller.admin.acOpenings.schedule;

import java.net.SocketException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.acOpenings.schedule.ScheduleDetails;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.schedule.ScheduleDetailsService;

/**
 * @author ashwini.shebe
 *
 */

@RestController
@CrossOrigin
public class ScheduleDetailsController {
	@Autowired
	private ScheduleDetailsService scheduleDetailsService;
	
	//--------------------Created By Ashwini Shebe For Get Record Of Schedule--------------------//
	@GetMapping("/schedule/ReceiptDate/{recDate}")
	public ResponseEntity<RequestResponse> getReceiptTableDataByDate(@PathVariable("recDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date recDate) {
		
		//System.out.println("accTransaction recDate===>>> "+recDate);
		List<ScheduleDetails> scheduleDetails = this.scheduleDetailsService.getScheduleDetails(recDate);
		System.out.println("accTransaction===>>> "+scheduleDetails);
		if (scheduleDetails == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					scheduleDetails);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, scheduleDetails);
		}
	} 
	
	
	@GetMapping("/reSchedulesDetails/{customerCode}/{scheduleNo}/{reScheduleDate}")
	public ResponseEntity<RequestResponse> getDataForReschedule(@PathVariable("customerCode") Long customerCode, @PathVariable("scheduleNo") Long scheduleNo, @PathVariable("reScheduleDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date transData) {
		
		//System.out.println("accTransaction recDate===>>> "+recDate);
		List<ScheduleDetails> scheduleDetails = this.scheduleDetailsService.getScheduleDetails(customerCode,scheduleNo,transData);
		System.out.println("accTransaction===>>> "+scheduleDetails);
		if (scheduleDetails == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					scheduleDetails);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, scheduleDetails);
		}
	} 
	
	@GetMapping("/reSchedulesDetails/{reScheduleDate}")
	public ResponseEntity<RequestResponse> getRescheduleData(@PathVariable("reScheduleDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date transData) {
		
		
//		System.out.println("accTransaction recDate===>>> "+recDate);
		List<ScheduleDetails> scheduleDetails = this.scheduleDetailsService.getScheduleListForReschedule(transData);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
				HttpStatus.ACCEPTED, scheduleDetails);
	}
	
	@GetMapping("/schedulesDetails/{reScheduleDate}")
	public ResponseEntity<RequestResponse> getScheduleList(@PathVariable("reScheduleDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date transData) {
		List<ScheduleDetails> scheduleDetails = this.scheduleDetailsService.getScheduleList(transData);
		System.out.println("Schedule Lst===>>> "+scheduleDetails);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,HttpStatus.ACCEPTED, scheduleDetails);
	}
	
	
   //--------------------Created By Anurag Ninawe For Recovery Receipt Form--------------------//
	@GetMapping("/scheduleForRecoveryReceipt/ReceiptDate/{recDate}")
	public ResponseEntity<RequestResponse> getReceiptTableDataByDateForRecoveryReceipt(@PathVariable("recDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date recDate) {
		
		//System.out.println("accTransaction recDate===>>> "+recDate);
		List<ScheduleDetails> scheduleDetails = this.scheduleDetailsService.getScheduleDetailsForRecoveryReceiptForm(recDate);
		System.out.println("accTransaction===>>> "+scheduleDetails);
		if (scheduleDetails == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,scheduleDetails);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,HttpStatus.ACCEPTED, scheduleDetails);
		}
	} 
	
	
	//--------------------Created By Ashwini Shebe For Update Receipt Approval Flag--------------------//
	@PutMapping("/schedulesDetails/updateReceiptFlag")
	public ResponseEntity<RequestResponse> updateReceiptFlagData(@RequestBody List<ScheduleDetails> scheduleDetailsForUpdate) throws JSONException, SocketException, ParseException {
		//List<AccTransaction> accTransListForSave = new ArrayList<>();
		List<ScheduleDetails> updateScheduleDetails = this.scheduleDetailsService.updateScheduleDetails(scheduleDetailsForUpdate);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess,
				HttpStatus.CREATED, scheduleDetailsForUpdate);
	}
	
	
	
	
	
	
	
	
}
