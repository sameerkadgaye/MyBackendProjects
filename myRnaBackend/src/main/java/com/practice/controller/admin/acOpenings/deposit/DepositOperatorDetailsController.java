/**
 * 
 */
package com.practice.controller.admin.acOpenings.deposit;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.dao.admin.acOpenings.deposit.DepositOperatorDetailsRepository;
import com.practice.model.admin.acOpenings.deposit.DepositOperatorDetails;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.deposit.DepositOperatorDetailsService;
import com.practice.util.AllUtils;

/**
 * @author SAMEER KADGAYE
 *
 */
@RestController
@CrossOrigin
public class DepositOperatorDetailsController {

	@Autowired
	private DepositOperatorDetailsService depositOperatorDetailsService;
	
	@Autowired
	private DepositOperatorDetailsRepository depositOperatorDetailsRepository;
	

	@GetMapping("/operatorDetails")
	public ResponseEntity<RequestResponse> getOperatorDetails() {
		List<DepositOperatorDetails> depositOperatorDetails = this.depositOperatorDetailsService.getDepositOperatorDetails();
		if (depositOperatorDetails.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.NOT_FOUND, depositOperatorDetails);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, depositOperatorDetails);
		}
	}
	
	@GetMapping("/operatorDetails/{depositAccountId}")
	public ResponseEntity<RequestResponse> getOperatorDetailsByDepositAccountId(@PathVariable("depositAccountId") Long depositAccountId) {
		List<DepositOperatorDetails> depositOperatorDetails = this.depositOperatorDetailsService.getDepositeAccountIdWiseDepositOperatorDetails(depositAccountId);
		if (depositOperatorDetails.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.ACCEPTED, depositOperatorDetails);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, depositOperatorDetails);
		}
	}

	@GetMapping("/operatorDetail/{depositOperatorDetailsId}")
	public ResponseEntity<RequestResponse> getDepositOperatorDetailsById(@PathVariable("depositOperatorDetailsId") Long depositOperatorDetailsId) {
		DepositOperatorDetails depositOperatorDetail = this.depositOperatorDetailsService.getDepositOperatorDetailsById(depositOperatorDetailsId);
		if (depositOperatorDetail == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND, depositOperatorDetail);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositOperatorDetail);
	}
	
	@GetMapping("/operatorDetail/depositeAccountId/{depositOperatorDetailsId}")
	public ResponseEntity<RequestResponse> getDepositeAccountIdByDepositOperatorDetailsId(@PathVariable("depositOperatorDetailsId") Long depositOperatorDetailsId) {
		Long depositeAccountIdByDepositAccountId = this.depositOperatorDetailsRepository.getDepositeAccountIdByDepositAccountId(depositOperatorDetailsId);
		System.out.println("depositeAccountIdByDepositAccountId  ===>>>> "+depositeAccountIdByDepositAccountId);
		if (depositeAccountIdByDepositAccountId == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.ACCEPTED, depositeAccountIdByDepositAccountId);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositeAccountIdByDepositAccountId);
	}

	@PostMapping("/operatorDetail")
	public ResponseEntity<RequestResponse> saveOperatorDetails(@Valid @RequestBody List<DepositOperatorDetails> depositOperatorDetails) throws UnknownHostException, SocketException {
		
		depositOperatorDetails.forEach(operator -> {
			try {
				operator.setStatus(false);
				operator.setIpAddress(AllUtils.getIpAddress());
				operator.setMacAddress(AllUtils.getMacAddress());
				System.out.println("depositOperatorDetails ====>>> "+operator.getOperationModeValueObj());
				operator.setOperationModeValue(operator.getOperationModeValueObj().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});	
		List<DepositOperatorDetails> saveDepositOperatorDetails = this.depositOperatorDetailsService.saveDepositOperatorDetails(depositOperatorDetails);
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED, saveDepositOperatorDetails);
	}
	
	
	@DeleteMapping("/operatorDetail/{depositOperatorDetailsId}")
	public ResponseEntity<RequestResponse> deleteOperatorDetailById(@PathVariable("depositOperatorDetailsId") Long depositOperatorDetailsId) {
		DepositOperatorDetails depositOperatorDetail = this.depositOperatorDetailsService.getDepositOperatorDetailsById(depositOperatorDetailsId);
		if (depositOperatorDetail == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND, depositOperatorDetail);
		} else {
			depositOperatorDetail.setStatus(true);
			DepositOperatorDetails savedDepositOperatorDetail = this.depositOperatorDetailsService.saveDepositOperatorDetail(depositOperatorDetail);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataDeleteSuccess, HttpStatus.OK, savedDepositOperatorDetail);
		}
	}
}
