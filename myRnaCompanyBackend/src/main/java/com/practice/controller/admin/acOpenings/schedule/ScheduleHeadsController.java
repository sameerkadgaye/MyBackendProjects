package com.practice.controller.admin.acOpenings.schedule;


import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.acOpenings.schedule.ScheduleHeads;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.schedule.ScheduleHeadsService;

/**
 * @author ashwini.shebe
 *
 */

@RestController
@CrossOrigin("*")
public class ScheduleHeadsController {
	@Autowired
	private ScheduleHeadsService scheduleHeadsService;
	
	
//	@GetMapping("/scheduleHeads/ReceiptDate/{recDate}")
//	public ResponseEntity<RequestResponse> getReceiptTableDataByDate(@PathVariable("recDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date recDate) throws JSONException {
//		List<ScheduleHeads> scheduleHeads = this.scheduleHeadsService.getScheduleHeads(recDate);
//		System.out.println("accTransaction of receipt===>>> "+scheduleHeads);
//		JSONArray jsonarray = new JSONArray(Arrays.asList(scheduleHeads) );
//		
//		System.out.println("jsonarray of  receipt===>>> "+jsonarray);
//		ScheduleHeads scheduleHeadsData = null;
//		for (int i=0;i < jsonarray.length();i++)
//		{
//			String receiptJsonObj = jsonarray.getString(i);
//			System.out.println("receiptJsonObj ======>>>>"+receiptJsonObj);
//			String[] data = receiptJsonObj.split(", scheduleId");
//			
//			for(String alist : data) {
//				String[] a = alist.split("accountNo=");
//				for(int j = 0; j <= a.length; j++) {
//					String accountNo = a[1];
//					System.out.println("Account No is : "+accountNo);
//					
//				}
//				
//			}
//			//long acno = receiptJsonObj.getLong("accountNo");
//			
//		}
		//scheduleHeadsData.setAccountNo(null);
//		if (scheduleHeads == null) {
//			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
//					scheduleHeads);
//		} else {
//			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
//					HttpStatus.ACCEPTED, scheduleHeads);
//		}
//	}
	
	@PostMapping("/scheduleHead")
	public ResponseEntity<RequestResponse> addDepositSchedule(@RequestBody ScheduleHeads scheduleHead) throws JSONException{
		
		System.out.println("Schedule Heads Data : "+scheduleHead);
		
//		JSONObject mainRoleObject = new JSONObject(new Gson().toJson(scheduleHead));
//		
//		System.out.println("schedule Data : "+mainRoleObject);
		this.scheduleHeadsService.addDepositSchedule(scheduleHead);
		
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.AccountApprove, HttpStatus.ACCEPTED,
				scheduleHead);
		
	}
	
	@GetMapping("/schedules/{customerCode}")
	public ResponseEntity<RequestResponse> getScheduleDetails(@PathVariable("customerCode") Long customerCode){		
		List<ScheduleHeads> scheduleHeads = this.scheduleHeadsService.getScheduleData(customerCode);
		System.out.println("accTransaction===>>> "+scheduleHeads);
		if (scheduleHeads == null || scheduleHeads.isEmpty()) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.ACCEPTED,
					scheduleHeads);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, scheduleHeads);
		}
	}
	
	
	@GetMapping("/getReschedule/{scheduleDetailsId}")
	public ResponseEntity<RequestResponse> getRescheduleData(@PathVariable("scheduleDetailsId") Long scheduleDetailsId){
		
		List<ScheduleHeads> scheduleHeads = this.scheduleHeadsService.getScheduleHeadsData(scheduleDetailsId);
		System.out.println("Reschedule No. and Schedule Date : "+scheduleHeads);
//		return scheduleNoAndScheduleDateData;
		
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
				HttpStatus.ACCEPTED, scheduleHeads);
		
	}
	
	@GetMapping("/getscheduleLists/{customerCode}/{accountNo}/{newScheduleStatus}/{scheduleType}")
	public ResponseEntity<RequestResponse> getScheduleListByCustomerCodeAccNoScheduleStatus(@PathVariable("customerCode") Long customerCode, @PathVariable("accountNo") Long accountNo,@PathVariable("newScheduleStatus") String newScheduleStatus, @PathVariable("scheduleType") String scheduleType){
		
		List<ScheduleHeads> scheduleHeads = this.scheduleHeadsService.getScheduleListByCustomerCodeAccNo(customerCode,accountNo,newScheduleStatus,scheduleType);
		System.out.println("Reschedule No. and Schedule Date : "+scheduleHeads);
//		return scheduleNoAndScheduleDateData;
		
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
				HttpStatus.ACCEPTED, scheduleHeads);
		
	}
	
	@GetMapping("/getscheduleLists/{customerCode}/{accountNo}/{scheduleType}")
	public ResponseEntity<RequestResponse> getScheduleListByCustomerCodeAccNo(@PathVariable("customerCode") Long customerCode, @PathVariable("accountNo") Long accountNo, @PathVariable("scheduleType") String scheduleType){
		
		List<ScheduleHeads> scheduleHeads = this.scheduleHeadsService.getAvailableScheduleListByCustomerCodeAccNo(customerCode,accountNo,scheduleType);
		System.out.println("Reschedule No. and Schedule Date : "+scheduleHeads);
//		return scheduleNoAndScheduleDateData;
		
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
				HttpStatus.ACCEPTED, scheduleHeads);
		
	}
	
	@PostMapping("/scheduleHead/{transId}")
	public ResponseEntity<RequestResponse> updateDepositSchedule(@PathVariable("transId") Long transId) throws JSONException{
		
		System.out.println("Schedule Heads Id : "+transId);
		
//		JSONObject mainRoleObject = new JSONObject(new Gson().toJson(scheduleHead));
//		
//		System.out.println("schedule Data : "+mainRoleObject);
		ScheduleHeads updateDepositSchedule = this.scheduleHeadsService.updateDepositSchedule(transId);
		System.out.println("Update Schedule : "+updateDepositSchedule);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.ACCEPTED,
				updateDepositSchedule);
		
	}
}
