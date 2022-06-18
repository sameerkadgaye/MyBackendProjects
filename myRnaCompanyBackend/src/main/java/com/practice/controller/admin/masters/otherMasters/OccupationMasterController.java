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
import com.practice.model.admin.masters.otherMaster.OccupationMaster;
import com.practice.model.common.ApplicationException;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.OccupationService;

/**
 * @author Anurag Ninawe
 * @version 0.1
 * 
 *          Created Date : 18/01/2022
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/master")
public class OccupationMasterController {

	@Autowired
	private OccupationService occupationService;

	@GetMapping("/occupations")
	public ResponseEntity<RequestResponse> getOccupations() {

		List<OccupationMaster> occupationLists = occupationService.getOccupations();
		if (occupationLists.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, occupationLists);
		}
	}

	@GetMapping("/occupation/{occupationId}")
	public ResponseEntity<RequestResponse> getOccupation(@PathVariable("occupationId") Long occupationId) {

		OccupationMaster Occupation = this.occupationService.getOccupationById(occupationId);

		if (Occupation == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, Occupation);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, Occupation);
		}
	}

	@PostMapping("/occupation")
	public ResponseEntity<RequestResponse> saveOccupationMaster(@RequestBody OccupationMaster occupation)throws Exception {
		
		try {
			this.occupationService.saveOccupationMaster(occupation);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,occupation);
		}
		
		catch (ApplicationException e) {
			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),HttpStatus.ALREADY_REPORTED, null);
			}
		
	}

	
	
	
	@DeleteMapping("/occupation/{occupationId}")
	public ResponseEntity<RequestResponse> deleteOccupation(@PathVariable("occupationId") Long occupationId)throws ApplicationException, Exception {
		System.out.println("Inside deleteOccupation Controller"+occupationId);
		OccupationMaster occupationbyId = this.occupationService.getOccupationById(occupationId);
		occupationbyId.setStatus(true);
		this.occupationService.updateOccupation(occupationbyId, occupationId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.CREATED,null);
	}
	

	
	
	
	
	
	

	@PutMapping("/occupation/{occupationId}")
	public ResponseEntity<RequestResponse> updateOccupation(@RequestBody OccupationMaster occupation,
			@PathVariable("occupationId") Long occupationId) throws Exception {

		try {
			this.occupationService.updateOccupation(occupation, occupationId);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
					HttpStatus.CREATED, occupationId);
		} catch (ApplicationException e) {
			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),
					HttpStatus.ALREADY_REPORTED, null);
		}

	}

}
