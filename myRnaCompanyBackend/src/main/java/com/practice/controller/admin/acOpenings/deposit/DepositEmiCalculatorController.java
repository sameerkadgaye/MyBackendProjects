package com.practice.controller.admin.acOpenings.deposit;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

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
import com.practice.model.admin.acOpenings.deposit.DepositEmiCalculator;
import com.practice.model.common.RequestResponse;
import com.practice.service.inf.admin.acOpenings.deposit.DepositAccountService;
import com.practice.service.inf.admin.acOpenings.deposit.DepositEmiCalculatorService;
import com.practice.util.AllUtils;

/**
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 20/12/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@RestController
@CrossOrigin
public class DepositEmiCalculatorController {

	@Autowired
	private DepositEmiCalculatorService depositEmiCalculatorService;

	@Autowired
	private DepositAccountService depositAccountService;

	@GetMapping("/desposit/accountNo/depositEmiCalculators/{accountNo}")
	public ResponseEntity<RequestResponse> getCustomerCodeWiseDepositAccounts(
			@PathVariable("accountNo") Long accountNo) {
		List<DepositEmiCalculator> depositEmiCalculatorList = this.depositEmiCalculatorService.getDepositEmiCalculatorsByDepositAccountNo(accountNo);

		if (depositEmiCalculatorList.size() <= 0) {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListNotFound,HttpStatus.NOT_FOUND, null);
		} else {
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataListFetchSuccess, HttpStatus.ACCEPTED, depositEmiCalculatorList.stream().filter(dec -> dec.getStatus() == false).collect(Collectors.toList()));
		}
	}
	
	@GetMapping("/depositEmiCalculator/{depositEmiCalculatorId}")
	public ResponseEntity<RequestResponse> getDepositEmiCalculatorById(
			@PathVariable("depositEmiCalculatorId") Long depositEmiCalculatorId) {
		DepositEmiCalculator depositEmiCalculatorById = this.depositEmiCalculatorService.getDepositEmiCalculatorById(depositEmiCalculatorId);
		if (depositEmiCalculatorById == null) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataNotFound, HttpStatus.NOT_FOUND, depositEmiCalculatorById);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositEmiCalculatorById);
	}
	
	@GetMapping("/depositEmiCalculator/depositAccountId/{depositAccountId}")
	public ResponseEntity<RequestResponse> getDepositAccountIdWiseDepositEmiCalculator(@PathVariable("depositAccountId") Long depositAccountId) {
		DepositEmiCalculator depositEmiCalculator = null;
		try {
			depositEmiCalculator = this.depositAccountService.getDepositAccountById(depositAccountId).getDepositEmiCalculator();
			if (depositEmiCalculator == null) {
				return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositEmiCalculator);
			}
		} catch (Exception e) {
			return RequestController.getBaseResponse(Constants.ErrorCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositEmiCalculator);
		}
		return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataFetchSuccess, HttpStatus.ACCEPTED, depositEmiCalculator);
	}

	@PostMapping("/depositEmiCalculator")
	public ResponseEntity<RequestResponse> saveOperatorDetails(@RequestBody DepositEmiCalculator depositEmiCalculator) throws UnknownHostException, SocketException {
		depositEmiCalculator.setIpAddress(AllUtils.getIpAddress());
		depositEmiCalculator.setMacAddress(AllUtils.getMacAddress());
		if (depositEmiCalculator.getDepositEmiCalculatorId() == null) {
			depositEmiCalculator.setStatus(false);
			System.out.println("depositEmiCalculator  id Not Exist========>>> " + depositEmiCalculator.getDepositEmiCalculatorId());
			DepositEmiCalculator savedDepositEmiCalculator = this.depositEmiCalculatorService.saveDepositEmiCalculator(depositEmiCalculator);
			// Setting Newly saved Deposit Account Data Into Deposit Account Starts
			if (savedDepositEmiCalculator != null) {
				if (savedDepositEmiCalculator.getDepositAccount().getDepositAccountId() != null) {
					DepositAccount depositAccountById = this.depositAccountService.getDepositAccountById(savedDepositEmiCalculator.getDepositAccount().getDepositAccountId());
					if (depositAccountById != null) {
						depositAccountById.setDepositEmiCalculator(savedDepositEmiCalculator);
						this.depositAccountService.saveDepositAccount(depositAccountById);
					}
				}
			}
			// Setting Newly saved Deposit Account Data Into Deposit Account Ends
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataSaveSuccess, HttpStatus.CREATED, savedDepositEmiCalculator);
		} else {
			System.out.println("depositEmiCalculator id If Exist========>>> " + depositEmiCalculator.getDepositEmiCalculatorId());
			DepositEmiCalculator updatedDepositEmiCalculator = this.depositEmiCalculatorService.saveDepositEmiCalculator(depositEmiCalculator);
			return RequestController.getBaseResponse(Constants.SuccessCode, Constants.DataUpdateSuccess, HttpStatus.CREATED, updatedDepositEmiCalculator);
		}
	}
}
