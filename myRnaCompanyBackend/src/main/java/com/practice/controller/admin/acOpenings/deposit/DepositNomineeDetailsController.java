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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.constants.Constants;
import com.practice.controller.common.RequestController;
import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.acOpenings.deposit.DepositNomineeDetails;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.deposit.DepositAccountService;
import com.practice.service.inf.admin.acOpenings.deposit.DepositNomineeDetailsService;
import com.practice.util.AllUtils;

/**
 * @author SAMEER KADGAYE
 *
 */
@RestController
@CrossOrigin
public class DepositNomineeDetailsController {

	@Autowired
	private DepositNomineeDetailsService depositNomineeDetailsService;
	
	@Autowired
	private DepositAccountService depositAccountService;

	@GetMapping("/depositNomineeDetails")
	public ResponseEntity<RequestResponse> getDepositAccounts() {
		List<DepositNomineeDetails> depositNomineeDetails = this.depositNomineeDetailsService.getDepositNomineeDetails();
		if (depositNomineeDetails.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.ACCEPTED, depositNomineeDetails);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, depositNomineeDetails);
		}
	}

	@GetMapping("/depositNomineeDetail/{despositNomineeDetailsId}")
	public ResponseEntity<RequestResponse> getDepositNomineeDetailsById(
			@PathVariable("despositNomineeDetailsId") Long despositNomineeDetailsId) {
		DepositNomineeDetails depositNomineeDetailsById = this.depositNomineeDetailsService.getDepositNomineeDetailsById(despositNomineeDetailsId);
		if (depositNomineeDetailsById == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND, depositNomineeDetailsById);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositNomineeDetailsById);
	}
	
	@GetMapping("/depositNomineeDetail/depositAccountId/{depositAccountId}")
	public ResponseEntity<RequestResponse> getDepositAccountIdWiseDepositNomineeDetails(@PathVariable("depositAccountId") Long depositAccountId) {
		DepositNomineeDetails depositNomineeDetails = null;
		try {
			depositNomineeDetails = this.depositAccountService.getDepositAccountById(depositAccountId).getDepositNomineeDetails();
			if (depositNomineeDetails == null) {
				return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositNomineeDetails);
			}
		} catch (Exception e) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositNomineeDetails);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositNomineeDetails);
	}

	@PostMapping("/depositNomineeDetail")
	public ResponseEntity<RequestResponse> saveStudent(@Valid @RequestBody DepositNomineeDetails depositNomineeDetails)
			throws UnknownHostException, SocketException {
			depositNomineeDetails.setIpAddress(AllUtils.getIpAddress());
			depositNomineeDetails.setMacAddress(AllUtils.getMacAddress());
			if (depositNomineeDetails.getDespositNomineeDetailsId() == null) {
				System.out.println("depositNomineeDetails  id Not Exist========>>> " + depositNomineeDetails.getDespositNomineeDetailsId());
				DepositNomineeDetails savedDepositNomineeDetails = this.depositNomineeDetailsService.saveDepositNomineeDetails(depositNomineeDetails);
				// Setting Newly saved Deposit Account Data Into Deposit Account Starts
				if (savedDepositNomineeDetails != null) {
					if (savedDepositNomineeDetails.getDepositAccount().getDepositAccountId() != null) {
						DepositAccount depositAccountById = this.depositAccountService.getDepositAccountById(savedDepositNomineeDetails.getDepositAccount().getDepositAccountId());
						if (depositAccountById != null) {
							depositAccountById.setDepositNomineeDetails(savedDepositNomineeDetails);
							this.depositAccountService.saveDepositAccount(depositAccountById);
						}
					}
				}
				// Setting Newly saved Deposit Account Data Into Deposit Account Ends
				return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED, savedDepositNomineeDetails);
			} else {
				System.out.println("depositNomineeDetails id If Exist========>>> " + depositNomineeDetails.getDespositNomineeDetailsId());
				DepositNomineeDetails updatedDepositNomineeDetails = this.depositNomineeDetailsService.saveDepositNomineeDetails(depositNomineeDetails);
				return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED, updatedDepositNomineeDetails);
			}
		}
}
