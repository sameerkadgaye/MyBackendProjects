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
import com.practice.model.admin.masters.glMaster.GlNoteContra;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.glMaster.GlNoteContraService;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 29/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@RestController
@CrossOrigin
@RequestMapping("master")
public class GlContraNoteController {
	
	@Autowired
	private GlNoteContraService glNoteContraService;
	
	@GetMapping("/glContraNotes")
	public ResponseEntity<RequestResponse> getGlMasterData() {
		List<GlNoteContra> glNoteContra = this.glNoteContraService.getGlNoteContraData();
		if (glNoteContra.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, glNoteContra);
		}
	}

}
