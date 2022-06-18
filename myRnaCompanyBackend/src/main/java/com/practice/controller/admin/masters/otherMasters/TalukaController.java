package com.practice.controller.admin.masters.otherMasters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.masters.otherMaster.TalukaMaster;
import com.practice.model.common.ApplicationException;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.TalukaService;

/**
 * @author Anurag Ninawe
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/master")
public class TalukaController {
	
	@Autowired TalukaService talukaService;
	
	@GetMapping("/talukas")
	public ResponseEntity<RequestResponse> getTalukas(){
	
		List<TalukaMaster> talukaLists = talukaService.getTalukas();
		if(talukaLists.size() <= 0)
		{
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.NOT_FOUND, null);
		}
		else
		{
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, talukaLists);
		}
	}	
	
	
	@GetMapping("/taluka/{talukaId}")
	public ResponseEntity<RequestResponse> getTaluka(@PathVariable("talukaId") Long talukaId){
	
		TalukaMaster Taluka = this.talukaService.getTalukaById(talukaId);
		
		if(Taluka == null)
		{
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.NOT_FOUND, Taluka);
		}
		else
		{
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, Taluka);
		}
	}
	
	@PostMapping("/taluka")
	public ResponseEntity<RequestResponse> saveTalukaMaster(@RequestBody TalukaMaster Taluka) throws Exception {
		
		try {
		this.talukaService.saveTalukaMaster(Taluka);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,Taluka);
		}
		
		catch (ApplicationException e) {
			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),HttpStatus.ALREADY_REPORTED, null);
			}
		
	}

	
	@DeleteMapping("/taluka/{talukaId}")
	public ResponseEntity<RequestResponse> deleteTaluka(@PathVariable("talukaId") Long talukaId) throws ApplicationException, Exception {
		System.out.println("Delete Mapping taluka Heated ===>>" + talukaId);
		TalukaMaster TalukabyId = this.talukaService.getTalukaById(talukaId);
		TalukabyId.setStatus(true);
		this.talukaService.updateTaluka(TalukabyId, talukaId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess,HttpStatus.CREATED, null);
	}
	
	
	
	@PutMapping("/taluka/{talukaId}")
	public ResponseEntity<RequestResponse> updatetaluka(@RequestBody TalukaMaster taluka,@PathVariable("talukaId") Long talukaId)  throws Exception {
		
//		this.talukaService.updateTaluka(taluka, talukaId);
//		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,talukaId);

		
		try {
			this.talukaService.updateTaluka(taluka, talukaId);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,talukaId);
		}
		
		catch (ApplicationException e) {
			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),HttpStatus.ALREADY_REPORTED, null);
			}
		
	}
	
	
	
	
}
