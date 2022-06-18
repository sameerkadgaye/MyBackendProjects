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
import com.practice.model.admin.masters.otherMaster.AdCompanyMst;
import com.practice.model.admin.masters.otherMaster.BranchMaster;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.CompanyMasterService;

/**
 * @author ashitosh.tabhane
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/master")
public class CompanyMasterController {

	@Autowired
	private CompanyMasterService companyMasterservice;

	@GetMapping("/companyMasters")
	public ResponseEntity<RequestResponse> getStateMaster() {
		List<AdCompanyMst> companyMaster = this.companyMasterservice.findByStatus(false);
		companyMaster.forEach(cm -> {
			System.out.println("company status ==>> "+cm.getStatus());
		});
		System.out.println("findStatesByStatus ============>>>>  " + companyMaster);
		if (companyMaster.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, companyMaster);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, companyMaster);
		}
	}

	@GetMapping("/companyMaster/{companyId}")
	public ResponseEntity<RequestResponse> getCompanyById(@PathVariable("companyId") int companyId) {
		AdCompanyMst companyMst = this.companyMasterservice.getCompanyById(companyId);
		if (companyMst == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					companyMst);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, companyMst);
		}
	}

	@PostMapping("/companyMaster")
	public ResponseEntity<RequestResponse> saveCompanyMaster(@RequestBody AdCompanyMst companyMaster) {
		companyMaster.setStatus(false);
		this.companyMasterservice.saveCompanydata(companyMaster);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED,
				companyMaster);
	}

	@PutMapping("/companyMaster/{adcmId}")
	public ResponseEntity<RequestResponse> checkCompanyMaster(@RequestBody AdCompanyMst companyMaster,@PathVariable("adcmId") int adcmId) {

		companyMaster.setStatus(false);
		this.companyMasterservice.updateCompanyMaster(companyMaster, adcmId);

		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED,
				companyMaster);
	}

	@DeleteMapping("/companyMaster/{adcmId}")
	public ResponseEntity<RequestResponse> deleteCompanyMster(@PathVariable("adcmId") Integer adcmId) {
		AdCompanyMst companyMaster = companyMasterservice.getCompanyByID(adcmId);
		companyMaster.setStatus(true);
		this.companyMasterservice.updateCompanyMaster(companyMaster, adcmId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.CREATED, companyMaster);
	}

//	For The Branch By Company Id
	@SuppressWarnings("unused")
	@GetMapping("/company/branch/{companyId}")
	public ResponseEntity<RequestResponse> getBranchByCompany(@PathVariable("companyId") int companyId) {
		AdCompanyMst companyMst = this.companyMasterservice.getCompanyById(companyId);
		List<BranchMaster> branchList = companyMst.getBranchList();
		if (companyMst == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND, branchList);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, branchList);
		}
	}
}
