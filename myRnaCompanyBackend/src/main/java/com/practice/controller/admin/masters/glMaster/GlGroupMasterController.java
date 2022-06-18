package com.practice.controller.admin.masters.glMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.masters.glMaster.GlGroupMaster;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.glMaster.GlGroupMasterService;

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
public class GlGroupMasterController {
	@Autowired
	private GlGroupMasterService glGroupMasterService;
	
	@GetMapping("/glGroupMasters")
	public ResponseEntity<RequestResponse> getGlMasterData() {
		List<GlGroupMaster> glGroupMaster = this.glGroupMasterService.getGlGroupMasterData();
		if (glGroupMaster.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, glGroupMaster);
		}
	}

}
