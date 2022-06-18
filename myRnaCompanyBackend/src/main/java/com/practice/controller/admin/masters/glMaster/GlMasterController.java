/**
 * 
 */
package com.practice.controller.admin.masters.glMaster;

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
import com.practice.model.admin.masters.glMaster.GlMaster;
import com.practice.model.common.ApplicationException;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.glMaster.GlMasterService;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 25/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@RestController
@RequestMapping("master")
@CrossOrigin
public class GlMasterController {
	@Autowired
	private GlMasterService glMasterServicel;

	@GetMapping("/glMasters")
	public ResponseEntity<RequestResponse> getGlMasterData() {
		List<GlMaster> glMaster = this.glMasterServicel.findGlMasterByStatus();
		if (glMaster.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, glMaster);
		}
	}

	@PostMapping("/glMaster")
	public ResponseEntity<RequestResponse> saveGlMasterData(@RequestBody GlMaster glMaster) throws ApplicationException {
		try {
			this.glMasterServicel.saveGlData(glMaster);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.ACCEPTED,glMaster);
		} catch (ApplicationException e) {
			e.printStackTrace();
			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(), HttpStatus.ALREADY_REPORTED, null);
		}
	}

	@GetMapping("/glMaster/{glId}")
	public ResponseEntity<RequestResponse> getGlMasterDataById(@PathVariable("glId") long glId) {
		GlMaster glMaster = this.glMasterServicel.getGlDataById(glId);
		if (glMaster == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					glMaster);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, glMaster);
		}
	}

	@PutMapping("/glMaster/{glId}")
	public ResponseEntity<RequestResponse> updateGlMasterData(@RequestBody GlMaster glMaster,
			@PathVariable("glId") long glId) {
		glMaster.setStatus(false);
		this.glMasterServicel.updateGlMaster(glMaster, glId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,
				glMaster);
	}

	@DeleteMapping("/glMaster/{glId}")
	public ResponseEntity<RequestResponse> deleteGLMasterDataById(@PathVariable("glId") long glId) {
		GlMaster glMaster = this.glMasterServicel.getGlDataById(glId);
		glMaster.setStatus(true);
		this.glMasterServicel.updateGlMaster(glMaster, glId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.CREATED,
				null);
	}
	
	@GetMapping("/glMaster/code/{glType}")
	public ResponseEntity<RequestResponse> getGlMasterMaxCode(@PathVariable("glType") String glType) {
		String code = this.glMasterServicel.getMaxGlCode(glType);
		if (code == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					code);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, code);
		}
	}

}
