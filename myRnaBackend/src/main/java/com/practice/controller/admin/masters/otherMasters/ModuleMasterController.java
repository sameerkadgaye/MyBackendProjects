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
import com.practice.dao.admin.masters.otherMasters.ModuleMasterRepository;
import com.practice.model.admin.masters.otherMaster.ModuleMaster;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.ModuleMasterService;

/**
 * @author Dolly Raut
 * @version 0.1
 * 
 *          Created Date : 30/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/master")
public class ModuleMasterController {

	@Autowired
	private ModuleMasterService moduleMasterService;
	@Autowired
	private ModuleMasterRepository moduleMasterRepository;

	@GetMapping("/module")
	public ResponseEntity<RequestResponse> getModuleMaster() {
		List<ModuleMaster> moduleMasterList = moduleMasterService.getModuleMaster();

		System.out.println("Inside module get controller =========>>> " + moduleMasterList);
		if (moduleMasterList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, moduleMasterList);
		}
	}

	@GetMapping("/module/{id}")
	public ResponseEntity<RequestResponse> getModuleMasterById(@PathVariable("id") Integer id) {
		ModuleMaster moduleMaster = moduleMasterService.getModuleMasterById(id);

		System.out.println("Inside module get by id controller =========>>> " + moduleMaster);
		if (moduleMaster == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, moduleMaster);
		}
	}

	@GetMapping("/module/seqNo/{seqno}")
	public ResponseEntity<RequestResponse> getSeqModuleMaster(@PathVariable("seqno") Integer seqno) {
		// System.out.println("Seq no =========>>> "+seqno);
		// this.moduleMasterService.deleteModuleMaster(seqno);
		ModuleMaster moduleMasterSeq = moduleMasterService.findBySeqNo(seqno);
		System.out.println("Seqno=" + moduleMasterSeq);
		if (moduleMasterSeq == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					moduleMasterSeq);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, moduleMasterSeq);
		}
	}

	@PostMapping("/module")
	public ResponseEntity<RequestResponse> saveModuleMaster(@RequestBody ModuleMaster moduleMaster) {
		System.out.println("Inside module save controller =========>>> " + moduleMaster);
		moduleMaster.setAdmmStatus(false);
		this.moduleMasterService.saveModuleMaster(moduleMaster);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
				moduleMaster);
	}

	@PutMapping("/module/{id}")
	public ResponseEntity<RequestResponse> getModuleMasterById(@PathVariable("id") int id,
			@RequestBody ModuleMaster moduleMaster) {
		moduleMasterService.updateModuleMaster(moduleMaster, id);
		if (moduleMaster == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					moduleMaster);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, moduleMaster);
		}
	}

	@DeleteMapping("/module/{id}")
	public ResponseEntity<RequestResponse> deleteModuleMaster(@PathVariable("id") Integer id) {
		System.out.println("Delete Mapping Heated ===>>" + id);
		ModuleMaster deleteModuleMaster = this.moduleMasterService.getModuleMasterById(id);
		deleteModuleMaster.setAdmmStatus(true);
		System.out.println("Delete status ===>>" + deleteModuleMaster.getAdmmStatus());
		this.moduleMasterService.updateModuleMaster(deleteModuleMaster, id);
		// this.pinCodeMasterService.deletePinCodeMaster(pinCodeId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess,
				HttpStatus.NO_CONTENT, null);
	}

}
