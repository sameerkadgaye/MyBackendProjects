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
import com.practice.dao.admin.acOpenings.deposit.DepositDetailsRepository;
import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.acOpenings.deposit.DepositDetails;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.deposit.DepositAccountService;
import com.practice.service.inf.admin.acOpenings.deposit.DepositDetailsService;

/**
 * @author SAMEER KADGAYE
 *
 */
@RestController
@CrossOrigin
public class DepositDetailsController {

	@Autowired
	private DepositDetailsService depositDetailsService;

	@Autowired
	private DepositAccountService depositAccountService;
	
	@Autowired
	private DepositDetailsRepository depositDetailsRepository;

	@GetMapping("/depositDetails")
	public ResponseEntity<RequestResponse> getDepositAccounts() {
		List<DepositDetails> depositDetails = this.depositDetailsService.getDepositDetails();
		if (depositDetails.size() <= 0) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataListNotFound, HttpStatus.ACCEPTED, depositDetails);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, depositDetails);
		}
	}

	@GetMapping("/depositDetail/receiptNo")
	public ResponseEntity<RequestResponse> getRecieptNo() {
		Long receiptNo = this.depositDetailsService.getReceiptNo();
		if (receiptNo == null) {
			receiptNo = (long) 1;
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess,
					HttpStatus.ACCEPTED, receiptNo);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED,
				receiptNo);
	}

	@PostMapping("/depositDetail")
	public ResponseEntity<RequestResponse> saveDepositDetails(@Valid @RequestBody DepositDetails depositDetails)
			throws UnknownHostException, SocketException {
		if (depositDetails.getDepositDetailsId() == null) {
			System.out.println("desposite Accoiunt desposite id Not Exist  ========>>> " + depositDetails.getDepositDetailsId());
			DepositDetails saveDepositDetails = this.depositDetailsService.saveDepositDetails(depositDetails);
			// Setting Newly saved Deposit Account Data Into Deposit Account Starts
			if (saveDepositDetails != null) {
				if (saveDepositDetails.getDepositAccount().getDepositAccountId() != null) {
					DepositAccount depositAccountById = this.depositAccountService.getDepositAccountById(saveDepositDetails.getDepositAccount().getDepositAccountId());
					if (depositAccountById != null) {
						depositAccountById.setDepositDetails(saveDepositDetails);
						this.depositAccountService.saveDepositAccount(depositAccountById);
					}
				}
			}
			// Setting Newly saved Deposit Account Data Into Deposit Account Ends
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED, saveDepositDetails);
		} else {
			System.out.println("desposite Accoiunt desposite id If Exist========>>> " + depositDetails.getDepositDetailsId());
			DepositDetails updatedDepositDetails = this.depositDetailsService.saveDepositDetails(depositDetails);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED, updatedDepositDetails);
		}
	}
	
	
	@GetMapping("/depositDetail/depositAccountId/{depositAccountId}")
	public ResponseEntity<RequestResponse> getDepositAccountIdWiseDepositDetails(@PathVariable("depositAccountId") Long depositAccountId) {
		System.out.println("getDepositAccountIdWiseDepositDetails =======>>>> ");
		DepositDetails depositDetails = null;
		try {
			depositDetails = this.depositAccountService.getDepositAccountById(depositAccountId).getDepositDetails();
			if (depositDetails == null) {
				return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositDetails);
			}
		} catch (Exception e) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositDetails);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositDetails);
	}
	
}
