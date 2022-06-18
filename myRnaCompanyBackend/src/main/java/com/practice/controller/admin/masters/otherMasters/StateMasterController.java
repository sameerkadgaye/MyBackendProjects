/**
 * 
 */
package com.practice.controller.admin.masters.otherMasters;

import java.util.ArrayList;
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
import com.practice.dao.admin.masters.otherMasters.StateMasterRepository;
import com.practice.model.admin.masters.otherMaster.DistrictMaster;
import com.practice.model.admin.masters.otherMaster.StateMaster;
import com.practice.model.common.ApplicationException;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.StateMasterService;

/**
 * @author ASHWINI SHEBE
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
@RequestMapping("master")
public class StateMasterController {

	@Autowired
	StateMasterService stateMasterService;

	@Autowired
	StateMasterRepository masterRepository;

	// Get All Record
	@GetMapping("/states")
	public ResponseEntity<RequestResponse> getStateMaster() {
		List<StateMaster> stateMaster = this.stateMasterService.findStatesByStatus();
		System.out.println("findStatesByStatus ============>>>>  " + stateMaster);
		if (stateMaster.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, stateMaster);
		}

	}

	// Save Record
	@PostMapping("/state")
	public ResponseEntity<RequestResponse> saveStateMaster(@RequestBody StateMaster stateMaster) {
		try {
			this.stateMasterService.saveState(stateMaster);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess,
					HttpStatus.CREATED, stateMaster);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),
					HttpStatus.ALREADY_REPORTED, null);
		}

	}

	// get id by record
	@GetMapping("/state/{stateId}")
	public ResponseEntity<RequestResponse> getStateMasterById(@PathVariable("stateId") Long stateId) {

		StateMaster stateMaster = stateMasterService.getStateById(stateId);
		if (stateMaster == null) {

			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					stateMaster);

		} else {

			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, stateMaster);

		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/state/districts/{stateId}")
	public ResponseEntity<RequestResponse> getDistrictByStateId(@PathVariable("stateId") Long stateId) {
		StateMaster stateMaster = stateMasterService.getStateById(stateId);
		if (stateMaster == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					stateMaster);
		} else {
			List<DistrictMaster> districtMasterList = new ArrayList();
			stateMaster.getDistrictMaster().forEach(dm -> {
				if (dm.getStatus() == false) {
					System.out.println(dm.getStatus());
					districtMasterList.add(dm);
				}
			});
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, districtMasterList);
		}
	}

	// delete id by record
	@DeleteMapping("/state/{stateId}")
	public ResponseEntity<RequestResponse> deleteStateMaster(@PathVariable("stateId") Long stateId) throws ApplicationException {
		StateMaster stateMaster = this.stateMasterService.getStateById(stateId);
		stateMaster.setStatus(true);
		this.stateMasterService.updateState(stateMaster, stateId);
		// this.stateMasterService.deleteState(stateId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.CREATED,
				null);

	}

	// update id by record
	@PutMapping("/state/{stateId}")
	public ResponseEntity<RequestResponse> updateStateMaster(@RequestBody StateMaster stateMaster,
			@PathVariable("stateId") Long stateId) {
		try {
			stateMaster.setStatus(false);
			this.stateMasterService.updateState(stateMaster, stateId);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,
					stateMaster);
			
		} catch (ApplicationException e) {
			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),
					HttpStatus.ALREADY_REPORTED, null);
		}
		
		

	}
}
