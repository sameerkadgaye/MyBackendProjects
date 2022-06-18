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
import com.practice.model.admin.masters.otherMaster.DistrictMaster;
import com.practice.model.admin.masters.otherMaster.TalukaMaster;
import com.practice.model.common.ApplicationException;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.masters.otherMasters.DistrictService;

/**
 * @author PALASH KHARWADE
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
public class DistrictController {

	@Autowired
	private DistrictService districtService;

	@GetMapping("/districts")
	public ResponseEntity<RequestResponse> getDistrict() {

		List<DistrictMaster> districtList = districtService.getDistrict();
		if (districtList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound,
					HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, districtList);
		}

	}

	@PostMapping("/district")
	public ResponseEntity<RequestResponse> saveDistrict(@RequestBody DistrictMaster district) throws Exception {
		System.out.println("districts Test =========>>> ");
		try {
			this.districtService.saveDistrict(district);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess,
					HttpStatus.CREATED, district);
		} catch (ApplicationException e) {
			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),
					HttpStatus.ALREADY_REPORTED, null);
		}
	}

	@GetMapping("/district/{districtId}")
	public ResponseEntity<RequestResponse> getDistrictById(@PathVariable("districtId") Long districtId) {
		DistrictMaster district = this.districtService.getDistrictById(districtId);
		if (district == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					district);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				district);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/district/talukas/{districtId}")
	public ResponseEntity<RequestResponse> getTalukaByDistrictId(@PathVariable("districtId") Long districtId) {

//	@GetMapping("/districts/taluka/{districtId}")
//	public ResponseEntity<RequestResponse> getDistrictByStateId(@PathVariable("districtId") Long districtId) {

		DistrictMaster districtMaster = districtService.getDistrictById(districtId);
		if (districtMaster == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND,
					districtMaster);
		} else {
			List<TalukaMaster> talukaMasterList = new ArrayList();
			districtMaster.getTalukaMaster().forEach(tm -> {
				if (tm.getStatus() == false) {
					System.out.println(tm.getStatus());
					talukaMasterList.add(tm);
				}
			});
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess,
					HttpStatus.ACCEPTED, talukaMasterList);
		}
	}

	@DeleteMapping("/district/{districtId}")
	public ResponseEntity<RequestResponse> deletePinCodeMaster(@PathVariable("districtId") Long districtId)
			throws ApplicationException {
		System.out.println("Delete Mapping Heated ===>>" + districtId);
		DistrictMaster districtbyid = this.districtService.getDistrictById(districtId);
		districtbyid.setStatus(true);
		this.districtService.updatedistrictMaster(districtbyid, districtId);
		// this.pinCodeMasterService.deletePinCodeMaster(pinCodeId);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.CREATED,
				null);

	}

	@PutMapping("/district/{districtId}")
	public ResponseEntity<RequestResponse> updateDistrict(@RequestBody DistrictMaster district,
			@PathVariable("districtId") Long districtId) throws ApplicationException {
		try {
			district.setStatus(false);
			this.districtService.updatedistrictMaster(district, districtId);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess,
					HttpStatus.CREATED, district);
		} catch (ApplicationException e) {
			return RequestController.getBaseResponse(e.getExceptionCode(), e.getExceptionMsg(),
					HttpStatus.ALREADY_REPORTED, null);
		}
	}
}
