/**
 * 
 */
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
import com.practice.model.admin.masters.otherMaster.PinCodeMaster;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.PinCodeMasterService;

/**
 * @author DOLLY RAUT
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
public class PinCodeMasterController {

	@Autowired
	private PinCodeMasterService pinCodeMasterService;

	@GetMapping("/")
	public String getHomePage() {
		return "PinCode Page";
	}

	@GetMapping("/pinCodes")
	public ResponseEntity<RequestResponse> getPinCodeMaster() {
		List<PinCodeMaster> pinCodeList = this.pinCodeMasterService.findPinCodeByStatus();
		//System.out.println("findPinCodeByStatus ============>>>>  " + pinCodeList);
		if (pinCodeList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,HttpStatus.NOT_FOUND, pinCodeList);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,HttpStatus.ACCEPTED, pinCodeList);
		}
	}

	@GetMapping("/pinCode/{pinCodeId}")
	public ResponseEntity<RequestResponse> getPinCodeMasterById(@PathVariable("pinCodeId") int pinCodeId) {
		PinCodeMaster pinCode = this.pinCodeMasterService.getPinCodeMasterById(pinCodeId);
		if (pinCode == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,pinCode);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,pinCode);
	}
	
	@GetMapping("/pinCode/code/{pinCode}")
	public ResponseEntity<RequestResponse> getPinCode(@PathVariable("pinCode") int pinCode) {
		PinCodeMaster findByPinCode = this.pinCodeMasterService.findByPinCode(pinCode);
		if (findByPinCode == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,findByPinCode);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,findByPinCode);
	}

	@PostMapping("/pinCode")
	public ResponseEntity<RequestResponse> savePinCodeMaster(@RequestBody PinCodeMaster pinCode) {
		System.out.println("Save Mapping Heated ===>>" + pinCode);
		try {
			pinCode.setStatus(false);
			this.pinCodeMasterService.savePinCodeMaster(pinCode);
		} catch (Exception e) {
			System.out.println("Inside Catch ===>>>>> ");
			e.printStackTrace();
		}
		
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
				pinCode);
	}

	@DeleteMapping("/pinCode/{pinCodeId}")
	public ResponseEntity<RequestResponse> deletePinCodeMaster(@PathVariable("pinCodeId") Integer pinCodeId) {
		System.out.println("Delete Mapping Heated ===>>" + pinCodeId);
		PinCodeMaster pinCode = this.pinCodeMasterService.getPinCodeMasterById(pinCodeId);
		pinCode.setStatus(true);
		this.pinCodeMasterService.updatePinCodeMaster(pinCode, pinCodeId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess,HttpStatus.NO_CONTENT, null);
	}

	@PutMapping("/pinCode/{pinCodeId}")
	public ResponseEntity<RequestResponse> updatePinCodeMaster(@RequestBody PinCodeMaster pinCode,
			@PathVariable("pinCodeId") Integer pinCodeId) {
		this.pinCodeMasterService.updatePinCodeMaster(pinCode, pinCodeId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,
				pinCode);
	}
}
