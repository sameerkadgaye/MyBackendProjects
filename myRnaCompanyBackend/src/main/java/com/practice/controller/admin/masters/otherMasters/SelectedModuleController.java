package com.practice.controller.admin.masters.otherMasters;

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
import com.practice.model.admin.masters.otherMaster.SelectedModule;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.SelectedModuleService;

@RestController
@CrossOrigin
@RequestMapping("/master")
public class SelectedModuleController {
	
	@Autowired
	private SelectedModuleService selectedModuleService;
	
	@GetMapping("/selectedModules")
	public ResponseEntity<RequestResponse> getModuleMaster(){
		List<SelectedModule> selectedModuleList =  selectedModuleService.getSelectedModule();
		
		System.out.println("Inside Selected get controller =========>>> "+selectedModuleList);
		if (selectedModuleList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, selectedModuleList);
		}
	}
}
