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
import com.practice.dao.admin.masters.otherMasters.BranchMasterRepository;
import com.practice.model.admin.masters.otherMaster.BranchMaster;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.BranchMasterService;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 11/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/master")
public class BranchMasterController {
	
	@Autowired
	BranchMasterService branchMasterService;
	

	@Autowired
	private BranchMasterRepository  branchMasterRepository;
	
	
	
	@GetMapping("/branches")
	public ResponseEntity<RequestResponse> getBranchMaster(){
		List<BranchMaster> branch = this.branchMasterService.findBranchMasterByStatus();
		System.out.println("branches ====>> "+branch);
		if (branch.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, branch);
		}
		
	}
	
	@PostMapping("/branch")
	public ResponseEntity<RequestResponse> saveBranchMaster(@RequestBody BranchMaster branch){
		
			this.branchMasterService.saveBranch(branch);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED, branch);
		
	}
	
	@GetMapping("/branch/{branchId}")
	public ResponseEntity<RequestResponse> getBranchById(@PathVariable("branchId") long branchId){
		BranchMaster branch = this.branchMasterService.getBranchById(branchId);
		if(branch==null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND, branch);
		}else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, branch);
		}
	}
	
	@DeleteMapping("/branch/{branchId}")
	public ResponseEntity<RequestResponse> deleteBranchById(@PathVariable("branchId") long branchId){
		BranchMaster branch = this.branchMasterService.getBranchById(branchId);
		branch.setStatus(true);
		this.branchMasterService.updateBranch(branch, branchId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.CREATED, null);
	}
	
	@PutMapping("/branch/{branchId}")
	public ResponseEntity<RequestResponse> updateBranchMaster(@RequestBody BranchMaster branch,
			@PathVariable("branchId") long branchId) {
		branch.setStatus(false);
		this.branchMasterService.updateBranch(branch, branchId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,
				branch);

	}
	
	
	@GetMapping("/branch/company/{adcmId}")
	public ResponseEntity<RequestResponse> getBranchByCompId(@PathVariable("adcmId") Integer adcmId) {
		
		List<BranchMaster> branchList = this.branchMasterRepository.findBranchByCompId(adcmId);

		if (branchList == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,branchList);
		}

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,branchList);
	}
	
	
	
	
	
}
